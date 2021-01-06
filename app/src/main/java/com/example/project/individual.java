package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class individual extends Fragment {
    String passwordLogin, node;
    EditText edtCurrentPassword, edtNewPassword, edtNewPasswordAgain;
    Button btnConfirm, btnCancel;
    DatabaseReference dataPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_individual, container, false);
        passwordLogin = getArguments().getString("password");
        node = getArguments().getString("node");
        edtCurrentPassword      = view.findViewById(R.id.editTextMaCodeCu);
        edtNewPassword          = view.findViewById(R.id.editTextNhapMaCodeMoi);
        edtNewPasswordAgain     = view.findViewById(R.id.editTextNhapLaiMaCode);
        btnConfirm              = view.findViewById(R.id.buttonXacNhanIndividual);
        btnCancel               = view.findViewById(R.id.buttonHuy);
        dataPassword = FirebaseDatabase.getInstance().getReference();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtCurrentPassword.getText().toString().equals(passwordLogin) && edtNewPassword.getText().toString().equals(edtNewPasswordAgain.getText().toString())){
                    dataPassword.child(node).child("password").setValue(edtNewPassword.getText().toString() + "");
                    Toast.makeText(getActivity(), "Đổi mã code thành công vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                else{
                    Toast.makeText(getActivity(), "Mã code nhập không đúng, vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}