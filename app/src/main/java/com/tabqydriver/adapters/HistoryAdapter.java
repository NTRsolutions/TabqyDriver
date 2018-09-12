package com.tabqydriver.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tabqydriver.R;
import com.tabqydriver.fragments.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{


    Context context;
    HistoryInterface historyInterface;


    public HistoryAdapter(Context context, HistoryInterface historyInterface){
        this.context = context;
        this.historyInterface = historyInterface;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.history_items,viewGroup,false);
        HistoryAdapter.MyViewHolder viewHolder=new HistoryAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView frag_history_iv_cx;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            frag_history_iv_cx = itemView.findViewById(R.id.frag_history_iv_cx);


        }
    }

    public interface HistoryInterface{
        void getDetails(int position);
    }
}
