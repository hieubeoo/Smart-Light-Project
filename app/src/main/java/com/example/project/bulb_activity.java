package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bulb_activity extends AppCompatActivity {

    ImageView imgBulb;
    Button btnOn, btnOff;
    DatabaseReference dataBulb;
    TextView txtTrangThaiDen, txtDoSang, txtNhietDo;
    CheckBox cbCheDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_activity);
        AnhXa();
       Intent intent = getIntent();
        final String node = intent.getStringExtra("node");
        //String password_login = intent.getStringExtra("passwordLogin");
        dataBulb = FirebaseDatabase.getInstance().getReference();
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
                    txtDoSang.setText(snapshot.getValue()+" lux");
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
//            cbCheDo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(cbCheDo.isChecked()){
//                        dataBulb.child(node).child("controlMode").setValue(1);
//                    }
//                    else {
//                        dataBulb.child(node).child("controlMode").setValue(0);
//                        btnOn.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                imgBulb.setImageResource(R.drawable.bulb_onn);
//                                txtTrangThaiDen.setText("Đèn đang bật");
//                                dataBulb.child(node).child("LedStatus").setValue(1);
//                            }
//                        });
//                        btnOff.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                txtTrangThaiDen.setText("Đèn tắt");
//                                imgBulb.setImageResource(R.drawable.bulb_off);
//                                dataBulb.child(node).child("LedStatus").setValue(0);
//                            }
//                        });
//                    }
//                }
//            });
//            cbCheDo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if(buttonView.isShown()){
//                        if(isChecked){
//                            dataBulb.child(node).child("controlMode").setValue(1);
//                        }
//                        else {
//                            dataBulb.child(node).child("controlMode").setValue(0);
//                            btnOn.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    imgBulb.setImageResource(R.drawable.bulb_onn);
//                                    txtTrangThaiDen.setText("Đèn đang bật");
//                                    dataBulb.child(node).child("LedStatus").setValue(1);
//                                }
//                            });
//                            btnOff.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    txtTrangThaiDen.setText("Đèn tắt");
//                                    imgBulb.setImageResource(R.drawable.bulb_off);
//                                    dataBulb.child(node).child("LedStatus").setValue(0);
//                                }
//                            });
//                        }
//                    }
//                }
//            });
        }
    }
    public void AnhXa(){
        imgBulb = findViewById(R.id.imageViewBulb);
        btnOff = findViewById(R.id.buttonTat);
        btnOn = findViewById(R.id.buttonBat);
        txtTrangThaiDen = findViewById(R.id.checkTrangThaiDen);
        txtDoSang = findViewById(R.id.doSangDen);
        txtNhietDo = findViewById(R.id.nhietDoPhong);
        cbCheDo = findViewById(R.id.checkBox);
    }
}