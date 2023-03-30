package com.example.mehboob.hunzabikeyarider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mehboob.hunzabikeyarider.databinding.ActivitySignInBinding;
import com.example.mehboob.hunzabikeyarider.databinding.ActivitySignupBinding;


public class SignUpActivity extends AppCompatActivity {


ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

       binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ChechValidation();
           }
       });

       binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
           }
       });


    }

    private void ChechValidation() {

        if (binding.edittextNumber.getText().toString().isEmpty() && binding.edittextNumber.getText().toString().trim().length()!=10)
        {
            Toast.makeText(this, "Enter A valid number", Toast.LENGTH_SHORT).show();
            binding.textviewError.setVisibility(View.VISIBLE);
        }

        else
        {
            String countryCode=      binding.ccp.getSelectedCountryCode();
            String number = binding.edittextNumber.getText().toString();
            String phoneNumber = "+"+countryCode+number;
            startActivity(new Intent(SignUpActivity.this,ProfileActivity.class));

        }
    }
}