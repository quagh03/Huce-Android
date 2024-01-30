package com.quagh.huceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button btnContinute;
    private EditText edEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        init();
        processEvents();
    }

    public void init(){
        btnContinute = findViewById(R.id.btnContinute);
        edEmail = findViewById(R.id.edEmail);

        if (btnContinute == null || edEmail == null) {
            throw new IllegalStateException("One or more views not found");
        }
    }

    public void processEvents() {
        btnContinute.setOnClickListener(view -> {
            if (validateInput()) {
                // Perform sign-up logic here
                // For demonstration purposes, display a success message
                String email = edEmail.getText().toString().trim();
                if ("quagh@gmail.com".equals(email)) {
                    Toast.makeText(this, "Sent to " + email, Toast.LENGTH_LONG).show();
                    verificationCodeActivity();
                } else {
                    Toast.makeText(this, "Email not found!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validateInput() {
        String email = edEmail.getText().toString().trim();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this,
                    "Enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void verificationCodeActivity(){
        Intent intent = new Intent(this, VerificationCodeActivity.class);
        startActivity(intent);
        finish();
    }

}