package com.example.mehboob.hunzabikeyarider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mehboob.hunzabikeyarider.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}