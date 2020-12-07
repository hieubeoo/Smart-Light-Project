package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bulb_activity extends AppCompatActivity {

    ImageView imgBulb;
    Button btnOn, btnOff;
    DatabaseReference dataBulb;
    TextView txtTrangThaiDen, txtDoSang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_activity);
        AnhXa();
        dataBulb = FirebaseDatabase.getInstance().getReference();
        dataBulb.child("user1").child("LedStatus").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue().toString().equals("1")){
                    txtTrangThaiDen.setText("Đèn đang bật");
                    imgBulb.setImageResource(R.drawable.bulb_onn);
                }
                else{
                    txtTrangThaiDen.setText("Đèn tắt");
                    imgBulb.setImageResource(R.drawable.bulb_off);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dataBulb.child("user1").child("light").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtDoSang.setText(snapshot.getValue()+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBulb.setImageResource(R.drawable.bulb_onn);
                dataBulb.child("user1").child("LedStatus").setValue(1);
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBulb.setImageResource(R.drawable.bulb_off);
                dataBulb.child("user1").child("LedStatus").setValue(0);
            }
        });
    }
    public void AnhXa(){
        imgBulb = findViewById(R.id.imageViewBulb);
        btnOff = findViewById(R.id.buttonTat);
        btnOn = findViewById(R.id.buttonBat);
        txtTrangThaiDen = findViewById(R.id.checkTrangThaiDen);
        txtDoSang = findViewById(R.id.doSangDen);
    }
}