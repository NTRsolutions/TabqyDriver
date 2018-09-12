package com.tabqydriver.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tabqydriver.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


    private Context context;
    ArrayList<Integer> images = new ArrayList<>();
    HomeInterface homeInterface;

    private int size;
    private String s;

    public HomeAdapter(Context context, String s, int size, HomeInterface homeInterface) {
        this.context = context;
        this.homeInterface = homeInterface;
        this.s = s;
        this.size = size;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.home_frag_items,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.home_frag_items_tv_paid.setText(R.string.cod);
        if(s.equals("New Delivery")){
            holder.frag_home_items_tv_accept.setVisibility(View.VISIBLE);
        } else {
            holder.frag_home_items_tv_accept.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return size;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView frag_home_items_iv_food;
        TextView frag_home_items_tv_accept;
        TextView home_frag_items_tv_paid;
        public MyViewHolder(View itemView) {
            super(itemView);

            frag_home_items_iv_food = itemView.findViewById(R.id.home_frag_items_iv_food);
            frag_home_items_tv_accept = itemView.findViewById(R.id.frag_home_items_tv_accept);
            home_frag_items_tv_paid = itemView.findViewById(R.id.home_frag_items_tv_paid);

            frag_home_items_tv_accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    homeInterface.getDetails(getAdapterPosition());
                }
            });
            }
    }

    public interface HomeInterface{
        void getDetails(int position);
    }
}


