package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bulbModeManual extends AppCompatActivity {

    ImageView imgBulb;
    DatabaseReference dataBulb;
    TextView txtTrangThaiDen, txtDoSang, txtNhietDo, txtRed, txtBlue, txtGreen;
    SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulb_mode_manual);
        AnhXa();
       Intent intent = getIntent();
        final String node = intent.getStringExtra("node");
        dataBulb = FirebaseDatabase.getInstance().getReference();
        seekBarRed.setMax(255);
        seekBarBlue.setMax(255);
        seekBarGreen.setMax(255);
        dataBulb.child(node).child("controlMode").setValue(0);
        if(intent != null){
            dataBulb.child(node).child("LedStatus1").addValueEventListener(new ValueEventListener() {
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
            dataBulb.child(node).child("light").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    txtDoSang.setText(snapshot.getValue()+" Lux");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            dataBulb.child(node).child("temparature").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    txtNhietDo.setText(snapshot.getValue()+ "");
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    dataBulb.child(node).child("controlRed").setValue(seekBar.getProgress());
                }
            });
            seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    dataBulb.child(node).child("controlBlue").setValue(seekBar.getProgress());
                }
            });
            seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    dataBulb.child(node).child("controlGreen").setValue(seekBar.getProgress());
                }
            });
            dataBulb.child(node).child("RED").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    txtRed.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            dataBulb.child(node).child("BLUE").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    txtBlue.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            dataBulb.child(node).child("GREEN").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    txtGreen.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    public void AnhXa(){
        imgBulb = findViewById(R.id.imageViewBulb);
        txtTrangThaiDen = findViewById(R.id.checkTrangThaiDen);
        txtDoSang = findViewById(R.id.doSangDen);
        txtNhietDo = findViewById(R.id.nhietDoPhong);
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarBlue = findViewById(R.id.seekBarBlue);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        txtRed = findViewById(R.id.textRed);
        txtBlue = findViewById(R.id.textBlue);
        txtGreen = findViewById(R.id.textGreen);
    }
}