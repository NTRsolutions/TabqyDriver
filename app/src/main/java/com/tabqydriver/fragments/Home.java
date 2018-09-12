package com.tabqydriver.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tabqydriver.activities.MainActivity;
import com.tabqydriver.adapters.HomeAdapter;
import com.tabqydriver.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements HomeAdapter.HomeInterface, View.OnClickListener {

    private Dialog dialog;
    private ImageView drawer_icon;
    private TextView dialog_decline,dialog_accept,dialog_tv_cross;
    private RecyclerView home_frag_recycler_view;
    private RelativeLayout frag_order_home_new_delivery_rel,frag_order_home_now_delivering_rel;
    private TextView frag_order_home_tv_new_delivery,frag_order_home_tv_new_deliveryb;
    private TextView frag_order_home_tv_now_delivering,frag_order_home_tv_now_deliveringb;
    private TextView frag_order_home_tv_not_delivered,frag_order_home_tv_not_deliveredb;
    private TextView frag_order_home_tv_delivered,frag_order_home_tv_deliveredb;
    private RelativeLayout frag_order_home_not_delivered_rel,frag_order_home_delivered_rel;
    private TextView frag_order_home_tv_notifications;
    private ImageView frag_order_home_iv_notifications;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private ArrayList<String> arr = new ArrayList<>();

    public void init(){

        home_frag_recycler_view = getView().findViewById(R.id.home_frag_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        home_frag_recycler_view.setLayoutManager(linearLayoutManager);


        setAdapter();

        createMyDialog();
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },3000);*/


        frag_order_home_new_delivery_rel = getView().findViewById(R.id.frag_order_home_new_delivery_rel);
        frag_order_home_now_delivering_rel = getView().findViewById(R.id.frag_order_home_now_delivering_rel);
        frag_order_home_not_delivered_rel = getView().findViewById(R.id.frag_order_home_not_delivered_rel);
        frag_order_home_delivered_rel = getView().findViewById(R.id.frag_order_home_delivered_rel);


        frag_order_home_tv_new_delivery = getView().findViewById(R.id.frag_order_home_tv_new_delivery);
        frag_order_home_tv_new_deliveryb = getView().findViewById(R.id.frag_order_home_tv_new_deliveryb);
        frag_order_home_tv_now_delivering = getView().findViewById(R.id.frag_order_home_tv_now_delivering);
        frag_order_home_tv_now_deliveringb = getView().findViewById(R.id.frag_order_home_tv_now_deliveringb);
        frag_order_home_tv_not_delivered = getView().findViewById(R.id.frag_order_home_tv_not_delivered);
        frag_order_home_tv_not_deliveredb = getView().findViewById(R.id.frag_order_home_tv_not_deliveredb);
        frag_order_home_tv_delivered = getView().findViewById(R.id.frag_order_home_tv_delivered);
        frag_order_home_tv_deliveredb = getView().findViewById(R.id.frag_order_home_tv_deliveredb);
        //frag_order_home_iv_notifications = getView().findViewById(R.id.frag_order_home_iv_notifications);

        drawer_icon = getView().findViewById(R.id.drawer_icon_iv);

        frag_order_home_new_delivery_rel.setOnClickListener(this);
        frag_order_home_now_delivering_rel.setOnClickListener(this);
        frag_order_home_not_delivered_rel.setOnClickListener(this);
        frag_order_home_delivered_rel.setOnClickListener(this);
        drawer_icon.setOnClickListener(this);
        //frag_order_home_iv_notifications.setOnClickListener(this);



    }

    private String str="New Delivery";
    private int size=10;

    public void setAdapter(){
        HomeAdapter homeAdapter = new HomeAdapter(getActivity() ,str, size, this);
        home_frag_recycler_view.setAdapter(homeAdapter);
    }

    private void createMyDialog(){
        dialog = new Dialog(getContext());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog_decline = dialog.findViewById(R.id.dialog_tv_decline);
        dialog_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog_accept = dialog.findViewById(R.id.dialog_tv_accept);
        dialog_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();

                Fragment fragment = new Order();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().addToBackStack(Order.class.getName());
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        dialog_tv_cross = dialog.findViewById(R.id.dialog_tv_cross);
        dialog_tv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public void getDetails(int position) {
        dialog.show();

        /*Fragment fragment = new Order();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.frag_order_home_new_delivery_rel){

            frag_order_home_tv_new_deliveryb.setText(Html.fromHtml(getString(R.string.newdeliveryb)));
            frag_order_home_tv_new_deliveryb.setVisibility(View.VISIBLE);
            frag_order_home_tv_new_delivery.setVisibility(View.GONE);
            frag_order_home_tv_now_delivering.setVisibility(View.VISIBLE);
            frag_order_home_tv_not_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_now_deliveringb.setVisibility(View.GONE);
            frag_order_home_tv_not_deliveredb.setVisibility(View.GONE);
            frag_order_home_tv_deliveredb.setVisibility(View.GONE);

            frag_order_home_new_delivery_rel.setBackgroundResource(R.drawable.button_gray_hollow_thin_left);
            frag_order_home_now_delivering_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_not_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow_right);

            size = 10;
            str = "New Delivery";
//            home_frag_recycler_view.setVisibility(View.VISIBLE);
            setAdapter();

        }
        else if (view.getId()==R.id.frag_order_home_now_delivering_rel){

            frag_order_home_tv_now_deliveringb.setText(Html.fromHtml(getString(R.string.nowdeliveringb)));
            frag_order_home_tv_now_deliveringb.setVisibility(View.VISIBLE);
            frag_order_home_tv_now_delivering.setVisibility(View.GONE);
            frag_order_home_tv_new_delivery.setVisibility(View.VISIBLE);
            frag_order_home_tv_not_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_new_deliveryb.setVisibility(View.GONE);
            frag_order_home_tv_not_deliveredb.setVisibility(View.GONE);
            frag_order_home_tv_deliveredb.setVisibility(View.GONE);

            frag_order_home_new_delivery_rel.setBackgroundResource(R.drawable.button_gray_hollow_left);
            frag_order_home_now_delivering_rel.setBackgroundResource(R.drawable.button_gray_thin_hollow);
            frag_order_home_not_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow_right);

            size = 3;
            str = "Now Delivery";
            setAdapter();

//            home_frag_recycler_view.setVisibility(View.VISIBLE);
        }
        else if (view.getId()==R.id.frag_order_home_not_delivered_rel){

            frag_order_home_tv_not_deliveredb.setText(Html.fromHtml(getString(R.string.notdeliveredb)));
            frag_order_home_tv_not_deliveredb.setVisibility(View.VISIBLE);
            frag_order_home_tv_not_delivered.setVisibility(View.GONE);
            frag_order_home_tv_now_delivering.setVisibility(View.VISIBLE);
            frag_order_home_tv_new_delivery.setVisibility(View.VISIBLE);
            frag_order_home_tv_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_now_deliveringb.setVisibility(View.GONE);
            frag_order_home_tv_new_deliveryb.setVisibility(View.GONE);
            frag_order_home_tv_deliveredb.setVisibility(View.GONE);

            frag_order_home_new_delivery_rel.setBackgroundResource(R.drawable.button_gray_hollow_left);
            frag_order_home_now_delivering_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_not_delivered_rel.setBackgroundResource(R.drawable.button_gray_thin_hollow);
            frag_order_home_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow_right);

            size = 7;
            str = "Not Delivered";
            setAdapter();

//            home_frag_recycler_view.setVisibility(View.VISIBLE);
        }
        else if (view.getId()==R.id.frag_order_home_delivered_rel){

            frag_order_home_tv_deliveredb.setText(Html.fromHtml(getString(R.string.deliveredb)));
            frag_order_home_tv_deliveredb.setVisibility(View.VISIBLE);
            frag_order_home_tv_delivered.setVisibility(View.GONE);
            frag_order_home_tv_now_delivering.setVisibility(View.VISIBLE);
            frag_order_home_tv_not_delivered.setVisibility(View.VISIBLE);
            frag_order_home_tv_new_delivery.setVisibility(View.VISIBLE);
            frag_order_home_tv_now_deliveringb.setVisibility(View.GONE);
            frag_order_home_tv_not_deliveredb.setVisibility(View.GONE);
            frag_order_home_tv_new_deliveryb.setVisibility(View.GONE);

            frag_order_home_new_delivery_rel.setBackgroundResource(R.drawable.button_gray_hollow_left);
            frag_order_home_now_delivering_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_not_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow);
            frag_order_home_delivered_rel.setBackgroundResource(R.drawable.button_gray_hollow_thin_right);

            size = 20;
            str = "Delivered";

            setAdapter();

//            home_frag_recycler_view.setVisibility(View.VISIBLE);
        }
        else if (view.getId()==R.id.drawer_icon_iv){
            MainActivity.drawer.openDrawer(GravityCompat.START);
        }
        else {}
        /*else if (view.getId()==R.id.frag_order_home_iv_notifications){
            dialog.show();
        }*/
    }
}
