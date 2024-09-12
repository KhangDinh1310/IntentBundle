package com.example.intentbundle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.intentbundle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final int COLOR_SELECTED = Color.parseColor("#c264ff");
    private final int COLOR_DEFAULT = Color.parseColor("#5f488b");
    private Button selectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTest.setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this, ResultActivity.class);
           if(!binding.edtA.getText().toString().isEmpty() && !binding.edtB.getText().toString().isEmpty() && selectedButton != null) {
               int a = Integer.parseInt(binding.edtA.getText().toString());
               int b = Integer.parseInt(binding.edtB.getText().toString());
               Bundle bundle = new Bundle();
               bundle.putInt("a", a);
               bundle.putInt("b", b);
               bundle.putString("operator", selectedButton.getText().toString());
               intent.putExtras(bundle);
           }
           startActivity(intent);
        });
        binding.btnPlus.setOnClickListener(v -> {
           setSelectedButton(binding.btnPlus);
        });
        binding.btnMinus.setOnClickListener(v -> {
            setSelectedButton(binding.btnMinus);
        });
        binding.btnMultiply.setOnClickListener(v -> {
            setSelectedButton(binding.btnMultiply);
        });
        binding.btnDivide.setOnClickListener(v -> {
            setSelectedButton(binding.btnDivide);
        });
    }
    private void setSelectedButton(Button button) {
        button.setBackgroundColor(COLOR_SELECTED);

        if (selectedButton != null && selectedButton != button) {
            selectedButton.setBackgroundColor(COLOR_DEFAULT);
        }
        selectedButton = button;
    }
}