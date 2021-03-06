package com.example.project;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {
    List<device> devices;
    recyclerViewAdapter recyclerViewAdapter;
    String node;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        node = getArguments().getString("node");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new recyclerViewAdapter(getContext(), devices, node);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        devices = new ArrayList<>();
        devices.add(new device("Phòng khách",R.drawable.living_room_project));
        devices.add(new device("Phòng bếp",R.drawable.kitchen_room_project));
        devices.add(new device("Phòng tắm",R.drawable.bath_room_project));
        devices.add(new device("Phòng ngủ",R.drawable.bed_room_project));
    }
}