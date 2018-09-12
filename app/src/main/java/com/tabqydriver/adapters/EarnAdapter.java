package com.tabqydriver.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tabqydriver.R;

public class EarnAdapter extends RecyclerView.Adapter<EarnAdapter.MyViewHolder> {

    Context context;
    EarnInterface earnInterface;

    public EarnAdapter(Context context,EarnInterface earnInterface){
        this.context = context;
        this.earnInterface = earnInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.earning_items,viewGroup,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        if (i==3){
            myViewHolder.earning_items_payment_status.setText(R.string.receivedbyrestaurant);
            myViewHolder.earning_items_payment_status.setTextColor(context.getResources().getColor(R.color.text_white));
            myViewHolder.earning_items_payment_status.setBackground(context.getResources().getDrawable(R.drawable.green_earn));
            myViewHolder.earning_items_payment_amount.setTextColor(context.getResources().getColor(R.color.GREEN));
            myViewHolder.earning_items_orderno.setTextColor(context.getResources().getColor(R.color.GREEN));
        }
        else if (i==2){
            myViewHolder.earning_items_payment_status.setText(R.string.submittedtotabqy);
        }
        else if (i==5){
            myViewHolder.earning_items_payment_status.setVisibility(View.INVISIBLE);
            myViewHolder.earning_items_tv_payment_status.setVisibility(View.INVISIBLE);
            myViewHolder.earning_items_orderno.setTextColor(context.getResources().getColor(R.color.text_light_black));
            myViewHolder.earning_items_payment_amount.setTextColor(context.getResources().getColor(R.color.text_light_black));
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }


    public interface EarnInterface{
        void getDetails(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView earning_items_payment_status;
        TextView earning_items_payment_amount;
        TextView earning_items_orderno;
        TextView earning_items_tv_payment_status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            earning_items_payment_status = itemView.findViewById(R.id.earning_items_payment_status);
            earning_items_payment_amount = itemView.findViewById(R.id.earning_items_payment_amount);
            earning_items_orderno = itemView.findViewById(R.id.earning_items_orderno);
            earning_items_tv_payment_status = itemView.findViewById(R.id.earning_items_tv_payment_status);

            earning_items_payment_status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    earnInterface.getDetails(getAdapterPosition());
                }
            });
        }
    }
}
