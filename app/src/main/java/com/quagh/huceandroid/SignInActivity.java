package com.quagh.huceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edUsername, edPassword;

    private TextView tvSignUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        processEvents();
    }

    public void init() {
        btnLogin = findViewById(R.id.btnLogin);
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        tvSignUpLink = findViewById(R.id.tvSignUp);

        if (btnLogin == null || edUsername == null || edPassword == null) {
            throw new IllegalStateException("One or more views not found");
        }
    }


    public void processEvents() {
        btnLogin.setOnClickListener(view -> {
            // Get username and password
            String username = edUsername.getText().toString().trim();
            String password = edPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Username or password cannot be empty", Toast.LENGTH_LONG).show();
                return;
            }

            // Check credentials
            if ("quagh03".equals(username) && "123".equals(password)) {
                Toast.makeText(this, "Successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
        tvSignUpLink.setOnClickListener(view -> {
            SignUpActivity();
        });
    }

    public void SignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}