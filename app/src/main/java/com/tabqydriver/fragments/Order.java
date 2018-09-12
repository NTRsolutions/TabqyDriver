package com.tabqydriver.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tabqydriver.R;
import com.tabqydriver.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Order extends Fragment implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    private ImageView frag_order_arrow_up;
    private RelativeLayout frag_order_detail_restaurant_rel,frag_order_blank_rel;
    private RelativeLayout frag_order_start_rel,frag_order_detail_rel;
    private TextView frag_order_tv_start;
    private View frag_order_res_first_circle,frag_order_res_line, frag_order_res_second_circle, frag_order_cx_first_circle, frag_order_cx_line, frag_order_cx_second_circle;
    private boolean status = true;
    private Dialog dialog,dialogNotDelivered,dialogPayment,dialogCxPhoneCall,dialogCxLocation;
    private TextView dialog_confirmation_tv_no, dialog_confirmation_tv_yes,dialog_confirmation_tv_confirm;
    private TextView frag_order_payment_mode,frag_order_cash;
    private ImageView frag_order_cx_phonecall,frag_order_cx_location,frag_order_res_location,frag_order_res_phonecall;
    private LinearLayout frag_order_deliver_lin;
    private TextView order_frag_tv_deliver,order_frag_tv_reached,order_frag_tv_pay;
    private TextView frag_order_tv_deliver;
    private TextView dialog_not_delivered_tv_submit,dialog_not_delivered_tv_cancel,dialog_not_delivered_tv_cross;
    private TextView dialog_payment_tv_ok,dialog_payment_tv_cross;
    private String str_spinner = "";
    private RadioGroup radio_group;
    private RadioButton dialog_payment_rb_cash,dialog_payment_rb_card;
    private EditText dialog_payment_et;
    private TextView dialog_payment_tv_charges,dialog_payment_tv_order;
    private TextView dialog_phonecall_tv_cross,dialog_location_tv_cross;
    private ImageView drawer_icon;



    public Order() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    public void init() {

        frag_order_arrow_up = getView().findViewById(R.id.frag_order_arrow_up);
        frag_order_cx_location = getView().findViewById(R.id.frag_order_cx_location);
        frag_order_cx_phonecall = getView().findViewById(R.id.frag_order_cx_phonecall);
        frag_order_res_location = getView().findViewById(R.id.frag_order_res_location);
        frag_order_res_phonecall = getView().findViewById(R.id.frag_order_res_phonecall);

        frag_order_detail_restaurant_rel = getView().findViewById(R.id.frag_order_detail_restaurant_rel);
        frag_order_blank_rel = getView().findViewById(R.id.frag_order_blank_rel);
        frag_order_start_rel = getView().findViewById(R.id.frag_order_start_rel);
        frag_order_detail_rel = getView().findViewById(R.id.frag_order_detail_rel);

        frag_order_tv_start = getView().findViewById(R.id.frag_order_tv_start);
        frag_order_payment_mode = getView().findViewById(R.id.frag_order_payment_mode);
        frag_order_cash = getView().findViewById(R.id.frag_order_cash);
        order_frag_tv_deliver = getView().findViewById(R.id.frag_order_tv_deliver);
        order_frag_tv_pay = getView().findViewById(R.id.frag_order_tv_pay);
        order_frag_tv_reached = getView().findViewById(R.id.frag_order_tv_reached);
        frag_order_tv_deliver = getView().findViewById(R.id.frag_order_tv_deliver);

        frag_order_res_line = getView().findViewById(R.id.frag_order_res_line);
        frag_order_cx_line = getView().findViewById(R.id.frag_order_cx_line);

        frag_order_res_first_circle = getView().findViewById(R.id.frag_order_res_first_circle);
        frag_order_res_second_circle = getView().findViewById(R.id.frag_order_res_second_circle);
        frag_order_cx_first_circle = getView().findViewById(R.id.frag_order_cx_first_circle);
        frag_order_cx_second_circle = getView().findViewById(R.id.frag_order_cx_second_circle);

        frag_order_deliver_lin = getView().findViewById(R.id.frag_order_deliver_lin);

        drawer_icon = getView().findViewById(R.id.drawer_icon_iv);

        //radio_group = getView().findViewById(R.id.radio_group);

        /*dialog_payment_rb_card = getView().findViewById(R.id.dialog_payment_rb_card);
        dialog_payment_rb_cash = getView().findViewById(R.id.dialog_payment_rb_cash);*/

        frag_order_arrow_up.setOnClickListener(this);
        frag_order_tv_start.setOnClickListener(this);
        frag_order_cx_phonecall.setOnClickListener(this);
        frag_order_cx_location.setOnClickListener(this);
        frag_order_res_phonecall.setOnClickListener(this);
        frag_order_res_location.setOnClickListener(this);
        order_frag_tv_deliver.setOnClickListener(this);
        order_frag_tv_pay.setOnClickListener(this);
        //order_frag_tv_reached.setOnClickListener(this);
        frag_order_detail_rel.setOnClickListener(this);
        drawer_icon.setOnClickListener(this);

        frag_order_tv_start.setVisibility(View.VISIBLE);

        createMyDialog();
        createMyDialogNotDelivered();
        createMyDialogPayment();
        createMyDialogCxPhonecall();
        createMyDialogCxLocation();
    }

    private void createMyDialog() {
        dialog = new Dialog(getContext());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_confirmation);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog_confirmation_tv_no = dialog.findViewById(R.id.dialog_confirmation_tv_no);
        dialog_confirmation_tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog_confirmation_tv_yes = dialog.findViewById(R.id.dialog_confirmation_tv_yes);
        dialog_confirmation_tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
                String text = dialog_confirmation_tv_confirm.getText().toString();
                if (text.equals("Start Pickup")){
                    Toast.makeText(getContext(), "Pickup started", Toast.LENGTH_SHORT).show();
                    frag_order_tv_start.setText(R.string.completepickup);
                    frag_order_res_first_circle.setBackground(getResources().getDrawable(R.drawable.button_green));
                }
                else if (text.equals("Complete Pickup")){
                    Toast.makeText(getContext(), "Pickup completed", Toast.LENGTH_SHORT).show();
                    frag_order_payment_mode.setVisibility(View.VISIBLE);
                    frag_order_cash.setVisibility(View.VISIBLE);
                    frag_order_tv_start.setText(R.string.startdelivery);
                    frag_order_res_line.setBackground(getResources().getDrawable(R.drawable.button_green));
                    frag_order_res_second_circle.setBackground(getResources().getDrawable(R.drawable.button_green));

                }
                else if (text.equals("Start Delivery")){
                    Toast.makeText(getContext(), "Delivery started", Toast.LENGTH_SHORT).show();
                    frag_order_start_rel.setVisibility(View.GONE);
                    frag_order_deliver_lin.setVisibility(View.VISIBLE);
                    /*frag_order_tv_start.setText(R.string.completedelivery);*/
                    frag_order_cx_first_circle.setBackground(getResources().getDrawable(R.drawable.button_green));

                }
                else if (text.equals("Complete Delivery")){
                    Toast.makeText(getContext(), "Delivery completed", Toast.LENGTH_SHORT).show();
                    frag_order_cx_line.setBackground(getResources().getDrawable(R.drawable.button_green));
                    frag_order_cx_second_circle.setBackground(getResources().getDrawable(R.drawable.button_green));
                }
                else {}
                /*else if (text.equals("Complete Delivery")){
                    Toast.makeText(getContext(), "Delivery completed", Toast.LENGTH_SHORT).show();
                    Fragment fragment = new Home();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }*/
            }
        });
        dialog_confirmation_tv_confirm = dialog.findViewById(R.id.dialog_confirmation_tv_confirm);

    }

    public void createMyDialogNotDelivered() {
        dialogNotDelivered = new Dialog(getContext());
        dialogNotDelivered.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogNotDelivered.setCancelable(false);
        dialogNotDelivered.setContentView(R.layout.dialog_not_delivered);
        dialogNotDelivered.getWindow().setBackgroundDrawable(null);

        dialog_not_delivered_tv_submit = dialogNotDelivered.findViewById(R.id.dialog_not_delivered_tv_submit);
        dialog_not_delivered_tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Submitted", Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStackImmediate();
                dialogNotDelivered.dismiss();
            }
        });

        dialog_not_delivered_tv_cancel = dialogNotDelivered.findViewById(R.id.dialog_not_delivered_tv_cancel);
        dialog_not_delivered_tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNotDelivered.dismiss();
            }
        });

        dialog_not_delivered_tv_cross = dialogNotDelivered.findViewById(R.id.dialog_not_delivered_tv_cross);
        dialog_not_delivered_tv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNotDelivered.dismiss();
            }
        });
    }

    public void createMyDialogPayment(){

        int count = 0;

        dialogPayment = new Dialog(getContext());
        dialogPayment.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPayment.setCancelable(false);
        dialogPayment.setContentView(R.layout.dialog_payment);
        dialogPayment.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog_payment_et = dialogPayment.findViewById(R.id.dialog_payment_et);
        radio_group = dialogPayment.findViewById(R.id.radio_group);
        radio_group.setOnCheckedChangeListener(this);

        dialog_payment_tv_ok = dialogPayment.findViewById(R.id.dialog_payment_tv_ok);
        dialog_payment_rb_cash = dialogPayment.findViewById(R.id.dialog_payment_rb_cash);
        dialog_payment_rb_card = dialogPayment.findViewById(R.id.dialog_payment_rb_card);
        dialog_payment_tv_order = dialogPayment.findViewById(R.id.dialog_payment_tv_order);
        dialog_payment_tv_charges = dialogPayment.findViewById(R.id.dialog_payment_tv_charges);


        dialog_payment_tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog_payment_rb_cash.isChecked()){
                Fragment fragment = new ThankYou();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content,fragment);
                fragmentTransaction.addToBackStack(ThankYou.class.getName());
                fragmentTransaction.commit();
                dialogPayment.dismiss();
            }
            else if (dialog_payment_rb_card.isChecked()){
                    Fragment fragment = new Signature();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content,fragment);
                    fragmentTransaction.addToBackStack(Signature.class.getName());
                    fragmentTransaction.commit();
                    dialogPayment.dismiss();
                }
                else {}
            }
        });

        dialog_payment_tv_cross = dialogPayment.findViewById(R.id.dialog_payment_tv_cross);
        dialog_payment_tv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPayment.dismiss();
            }
        });

        String[] card = new String[]{"Card","Debit card","Credit card"};
        final Spinner dialog_payment_spinner;
        dialog_payment_spinner = dialogPayment.findViewById(R.id.dialog_payment_spinner);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( getContext(),R.layout.spinner_item,card);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        dialog_payment_spinner.setAdapter(arrayAdapter);

        dialog_payment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_spinner = arrayAdapter.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (count==0) {
            dialog_payment_spinner.setEnabled(false);
            dialog_payment_et.setEnabled(false);
        }
    }

    public void createMyDialogCxPhonecall(){

        dialogCxPhoneCall = new Dialog(getContext());
        dialogCxPhoneCall.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCxPhoneCall.setCancelable(false);
        dialogCxPhoneCall.setContentView(R.layout.dialog_phonecall);
        dialogCxPhoneCall.getWindow().setBackgroundDrawable(null);

        dialog_phonecall_tv_cross = dialogCxPhoneCall.findViewById(R.id.dialog_phonecall_tv_cross);
        dialog_phonecall_tv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCxPhoneCall.dismiss();
            }
        });
    }



    private void createMyDialogCxLocation() {
        dialogCxLocation = new Dialog(getContext());
        dialogCxLocation.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCxLocation.setCancelable(false);
        dialogCxLocation.setContentView(R.layout.dialog_cx_location);
        dialogCxLocation.getWindow().setBackgroundDrawable(null);

        dialog_location_tv_cross = dialogCxLocation.findViewById(R.id.dialog_location_tv_cross);
        dialog_location_tv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCxLocation.dismiss();
            }
        });
    }



    /*public void createMyDialogPayment1(){
        dialogPayment = new Dialog(getContext());
        dialogPayment.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPayment.setCancelable(false);
        dialogPayment.setContentView(R.layout.dialog_payment_1);
        dialogPayment.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }*/

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.frag_order_detail_rel) {
            if (status) {
                frag_order_arrow_up.setImageResource(R.drawable.ic_arrow_down);
                frag_order_detail_restaurant_rel.setVisibility(View.GONE);
                frag_order_blank_rel.setVisibility(View.VISIBLE);
                status = false;
            } else {
                frag_order_arrow_up.setImageResource(R.drawable.ic_arrow_up);
                frag_order_detail_restaurant_rel.setVisibility(View.VISIBLE);
                frag_order_blank_rel.setVisibility(View.GONE);
                status = true;
            }
        } else if (view.getId() == R.id.frag_order_tv_start) {
            String value = frag_order_tv_start.getText().toString();
            if (value.equals("Start Pickup")) {
                dialog.show();
                /*Toast.makeText(getContext(), "Pickup started", Toast.LENGTH_SHORT).show();
                frag_order_tv_start.setText(R.string.completepickup);
                frag_order_res_line.setBackground(getResources().getDrawable(R.drawable.button_green));
                frag_order_res_second_circle.setBackground(getResources().getDrawable(R.drawable.button_green));*/
            } else if (value.equals("Complete Pickup")) {
                dialog.show();
                dialog_confirmation_tv_confirm.setText(R.string.completepickup);
                /*Toast.makeText(getContext(), "Pickup completed", Toast.LENGTH_SHORT).show();
                frag_order_tv_start.setText(R.string.startdelivery);
                frag_order_cx_first_circle.setBackground(getResources().getDrawable(R.drawable.button_green));*/
            } else if (value.equals("Start Delivery")) {
                dialog.show();
                dialog_confirmation_tv_confirm.setText(R.string.startdelivery);
                /*Toast.makeText(getContext(), "Pickup delivery", Toast.LENGTH_SHORT).show();
                frag_order_tv_start.setText(R.string.completedelivery);
                frag_order_cx_line.setBackground(getResources().getDrawable(R.drawable.button_green));
                frag_order_cx_second_circle.setBackground(getResources().getDrawable(R.drawable.button_green));*/
            } else if (value.equals("Complete Delivery")) {
                dialog.show();
                dialog_confirmation_tv_confirm.setText(R.string.completedelivery);
                /*Toast.makeText(getContext(), "Delivery completed", Toast.LENGTH_SHORT).show();*/
            }
            else {}
        }else if (view.getId()==R.id.frag_order_cx_phonecall){
            dialogCxPhoneCall.show();
        }
        else if (view.getId()==R.id.frag_order_cx_location){
            //dialogCxLocation.show();
                    Fragment fragment = new Location();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content,fragment).addToBackStack(Location.class.getName()).commit();
        }
        else if (view.getId()==R.id.frag_order_res_location){}
        else if (view.getId()==R.id.frag_order_res_phonecall){}

        else if (view.getId()==R.id.frag_order_tv_deliver){
            dialogNotDelivered.show();
            Toast.makeText(getActivity(), "NOT DELIVERED", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.frag_order_tv_pay){
            dialogPayment.show();
            Toast.makeText(getActivity(), "PAY", Toast.LENGTH_SHORT).show();
        }
        /*else if (view.getId()==R.id.frag_order_tv_reached){
            Toast.makeText(getActivity(), "REACHED", Toast.LENGTH_SHORT).show();
        }*/
        else if (view.getId()==R.id.drawer_icon_iv){
            MainActivity.drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId()==R.id.radio_group){

            int id = radioGroup.getCheckedRadioButtonId();
            if (id==R.id.dialog_payment_rb_cash){
                String[] card = new String[]{"Card","Debit card","Credit card"};
                final Spinner dialog_payment_spinner;
                dialog_payment_spinner = dialogPayment.findViewById(R.id.dialog_payment_spinner);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( getContext(),R.layout.spinner_item,card);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                dialog_payment_spinner.setAdapter(arrayAdapter);

                dialog_payment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        str_spinner = arrayAdapter.getItem(i);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                    /*dialog_payment_spinner.setEnabled(false);
                    dialog_payment_et.setEnabled(false);*/
                    dialog_payment_spinner.setVisibility(View.INVISIBLE);
                    dialog_payment_et.setVisibility(View.INVISIBLE);
                    dialog_payment_tv_order.setVisibility(View.VISIBLE);
                    dialog_payment_tv_charges.setVisibility(View.VISIBLE);

            }

            else if (id==R.id.dialog_payment_rb_card){
                String[] card = new String[]{"Select Card","Debit card","Credit card"};
                final Spinner dialog_payment_spinner;
                dialog_payment_spinner = dialogPayment.findViewById(R.id.dialog_payment_spinner);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( getContext(),R.layout.spinner_item,card);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                dialog_payment_spinner.setAdapter(arrayAdapter);

                dialog_payment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        str_spinner = arrayAdapter.getItem(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                    dialog_payment_spinner.setVisibility(View.VISIBLE);
                    dialog_payment_et.setVisibility(View.VISIBLE);
                dialog_payment_tv_order.setVisibility(View.INVISIBLE);
                dialog_payment_tv_charges.setVisibility(View.INVISIBLE);
                dialog_payment_spinner.setEnabled(true);
                dialog_payment_et.setEnabled(true);

            }
            else {}
        }
    }
}
