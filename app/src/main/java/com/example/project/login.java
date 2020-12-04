package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    Button btnDangNhap;
    EditText edtMaCode;
    CheckBox cbNhoMatKhau;
    TextView txtQuenMatKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void AnhXa(){
        btnDangNhap = findViewById(R.id.buttonDangNhap);
        edtMaCode = findViewById(R.id.editTextNhapMaCode);
        cbNhoMatKhau = findViewById(R.id.checkboxNhoMatKhau);
        txtQuenMatKhau = findViewById(R.id.textQuenMatKhau);
    }
}