package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class bulb_activity extends AppCompatActivity {

    ImageView imgBulb;
    Button btnOn, btnOff;
    SeekBar skDoSang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_activity);
        AnhXa();
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBulb.setImageResource(R.drawable.bulb_onn);
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgBulb.setImageResource(R.drawable.bulb_off);
            }
        });

    }
    public void AnhXa(){
        imgBulb = findViewById(R.id.imageViewBulb);
        btnOff = findViewById(R.id.buttonTat);
        btnOn = findViewById(R.id.buttonBat);
        skDoSang = findViewById(R.id.seekBar);
    }
}