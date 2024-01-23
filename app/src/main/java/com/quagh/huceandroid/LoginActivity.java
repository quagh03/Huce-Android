package com.quagh.huceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edUsername, edPassword;

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

        if (btnLogin == null || edUsername == null || edPassword == null) {
            // Handle the case where one of the views is not found
            throw new IllegalStateException("One or more views not found");
        }
    }


    public void processEvents(){
        btnLogin.setOnClickListener(view -> {
            //Get username and password
            String username = edUsername.getText().toString();
            String password = edPassword.getText().toString();
            if(!username.equals("")){
                Toast.makeText(this,username,Toast.LENGTH_LONG).show();
            }
        });
    }
}