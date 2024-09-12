package com.example.intentbundle;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intentbundle.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int a = 0, b = 0;
        String operator = "";
        if(bundle != null) {
            a = bundle.getInt("a");
            b = bundle.getInt("b");
            operator = bundle.getString("operator");
        }
        switch (operator) {
            case "X":
                binding.textResult.setText(String.valueOf(a * b));
                break;
            case "/":
                binding.textResult.setText(String.valueOf(a / b));
                break;
            case "+":
                binding.textResult.setText(String.valueOf(a + b));
            case "-":
                binding.textResult.setText(String.valueOf(a - b));
        }

        binding.btnBack.setOnClickListener(v -> {
           Intent intent1 = new Intent(ResultActivity.this, MainActivity.class);
           startActivity (intent1);
        });
        String result = binding.textResult.getText().toString();
        binding.btnX2.setOnClickListener(v -> {
            binding.textResult.setText(String.valueOf(Integer.parseInt(result) * Integer.parseInt(result)));
        });
        binding.btnR2.setOnClickListener(v -> {
            binding.textResult.setText(String.valueOf(Math.sqrt(Integer.parseInt(result))));
        });
    }
}