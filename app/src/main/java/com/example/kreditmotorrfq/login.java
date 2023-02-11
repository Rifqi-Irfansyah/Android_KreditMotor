package com.example.kreditmotorrfq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button bukalogin;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username    = findViewById(R.id.nama);
        password    = findViewById(R.id.passwordna);
        bukalogin   = findViewById(R.id.button);

        bukalogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();
                if(usernameKey.equals("admin") && passwordKey.equals("admin")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setMessage("Username atau Password Salah !!")
                            .setNegativeButton("Coba Lagi", null).create().show();
                }
            }
        });
    }
}