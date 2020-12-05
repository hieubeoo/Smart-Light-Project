package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;
import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<device> deviceList;
    public recyclerViewAdapter(Context context, List<device> deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mLayout = LayoutInflater.from(context);
        view = mLayout.inflate(R.layout.card_view_device,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtDevice.setText(deviceList.get(position).getTen());
        holder.img.setImageResource(deviceList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return deviceList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtDevice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewCardView);
            txtDevice = itemView.findViewById(R.id.textViewCardView);
        }
    }
}
