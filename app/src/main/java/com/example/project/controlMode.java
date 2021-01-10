package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class controlMode extends AppCompatActivity {
    ImageView imgAutoMode, imgManualMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_mode);
        imgAutoMode = findViewById(R.id.imageModeAuto);
        imgManualMode = findViewById(R.id.imageModeManual);
        Intent intentGetNode = getIntent();
        final String node = intentGetNode.getStringExtra("node");
        imgAutoMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTransfer = new Intent(controlMode.this, bulbModeAuto.class)
                        .putExtra("node",node);
                startActivity(intentTransfer);
            }
        });
        imgManualMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenTransfer = new Intent(controlMode.this, bulbModeManual.class)
                        .putExtra("node", node);
                startActivity(intenTransfer);
            }
        });
    }
}