package com.quagh.huceandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private Button btnSignUp;
    private TextView tvSignInLink;
    private EditText edEmail, edUsername, edPassword, edConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        processEvents();
    }

    public void init() {
        btnSignUp = findViewById(R.id.btnSignup);
        tvSignInLink = findViewById(R.id.tvSignInLink);
        edEmail = findViewById(R.id.edEmail);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
    }

    public void processEvents() {
        btnSignUp.setOnClickListener(view -> {
            if (validateInput()) {
                // Perform sign-up logic here
                // For demonstration purposes, display a success message
                Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show();
            }
        });

        tvSignInLink.setOnClickListener(view -> {
            signInActivity();
        });
    }

    private boolean validateInput() {
        String email = edEmail.getText().toString().trim();
        String username = edUsername.getText().toString().trim();
        String password = edPassword.getText().toString();
        String confirmPassword = edConfirmPassword.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (username.isEmpty()) {
            Toast.makeText(this, "Enter a username", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty() || password.length() < 6) {
            Toast.makeText(this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void signInActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish(); // Optional: Finish the current activity if you don't want it in the back stack
    }
}
