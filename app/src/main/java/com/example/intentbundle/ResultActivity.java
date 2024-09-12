package com.example.intentbundle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }
}