package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    home fragment_home ;
    Bundle bundleNode = new Bundle();
    Bundle bundlePassword = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragment_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Intent intent = getIntent();
        String matkhau_login = intent.getStringExtra("password");
        String node = intent.getStringExtra("node");
        bundlePassword.putString("password", matkhau_login);
        bundlePassword.putString("node",node);
        bundleNode.putString("node", node);
        if(savedInstanceState == null){
            fragment_home = new home();
            fragment_home.setArguments(bundleNode);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment_home).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectFragment = null;
                        switch (item.getItemId()){
                            case R.id.fragment_home:
                                selectFragment = new home();
                                selectFragment.setArguments(bundleNode);
                                break;
                            case R.id.fragment_individual:
                                selectFragment = new individual();
                                selectFragment.setArguments(bundlePassword);
                                break;
                            case R.id.fragment_information:
                                selectFragment = new information();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
                        return true;
                }
            };
}