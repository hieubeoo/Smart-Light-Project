package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button btnDangNhap;
    EditText edtMaCode;
    CheckBox cbNhoMatKhau;
    TextView txtQuenMatKhau;
    DatabaseReference dataDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        AnhXa();
        dataDangNhap = FirebaseDatabase.getInstance().getReference();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dataDangNhap.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (final DataSnapshot postDataSnapshotUser : snapshot.getChildren()){
                        dataDangNhap.child(postDataSnapshotUser.getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot postDataSnapshotPassword : snapshot.getChildren()){
                                    if(postDataSnapshotPassword.getValue().toString().equals(edtMaCode.getText().toString()) && edtMaCode.getText().toString().length() > 5){
                                        Intent intent = new Intent(login.this, MainActivity.class).putExtra("password", edtMaCode.getText().toString())
                                                .putExtra("node", postDataSnapshotUser.getKey());
                                        startActivity(intent);
                                        Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
//            dataDangNhap.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//              for( final DataSnapshot postDataSnapshotUser : snapshot.getChildren()){
//                  dataDangNhap.child(postDataSnapshotUser.getKey()).addValueEventListener(new ValueEventListener() {
//                      @Override
//                      public void onDataChange(@NonNull DataSnapshot snapshot) {
//                          for (DataSnapshot postDataSnapshotPassword : snapshot.getChildren()){
//                              if(postDataSnapshotPassword.getValue().toString().equals(edtMaCode.getText().toString()) && edtMaCode.getText().toString().length() > 5){
//                                  Intent intent = new Intent(login.this, MainActivity.class).putExtra("password", edtMaCode.getText().toString())
//                                          .putExtra("node", postDataSnapshotUser.getKey());
//                                  startActivity(intent);
//                                  break;
//                              }
//                          }
//                      }
//                      @Override
//                      public void onCancelled(@NonNull DatabaseError error) {
//
//                      }
//                  });
//                  break;
//               }
//           }
//           @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//     
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