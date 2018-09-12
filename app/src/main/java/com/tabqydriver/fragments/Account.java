package com.tabqydriver.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabqydriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment implements View.OnClickListener {

    private LinearLayout frag_account_arrow_password;
    private TextView frag_account_tv_edit,frag_account_tv_manage;

    public Account() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    public void init() {
        frag_account_arrow_password = getView().findViewById(R.id.frag_account_arrow_password);
        frag_account_tv_edit = getView().findViewById(R.id.frag_account_tv_edit);
        frag_account_tv_manage = getView().findViewById(R.id.frag_account_tv_manage);

        frag_account_arrow_password.setOnClickListener(this);
        frag_account_tv_edit.setOnClickListener(this);
        frag_account_tv_manage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.frag_account_arrow_password) {
            Fragment fragment = new ChangePassword();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment)
                    .addToBackStack(ChangePassword.class.getName()).commit();
        }
        else if (view.getId()==R.id.frag_account_tv_edit){
            Fragment fragment = new EditAccount();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content,fragment)
                    .addToBackStack(EditAccount.class.getName()).commit();
        }
        else if (view.getId()==R.id.frag_account_tv_manage){
            Fragment fragment = new ManageAddress();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content,fragment)
                    .addToBackStack(ManageAddress.class.getName()).commit();
        }

    }
}


