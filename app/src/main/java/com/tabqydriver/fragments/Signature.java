package com.tabqydriver.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.tabqydriver.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Signature extends Fragment implements View.OnClickListener {

    TextView frag_signature_tv_signature,frag_signature_tv_ok,frag_signature_tv_cancel;


    public Signature() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signature, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }


    public void init(){

        frag_signature_tv_signature = getView().findViewById(R.id.frag_signature_tv_signature);
        frag_signature_tv_ok = getView().findViewById(R.id.frag_signature_tv_ok);
        frag_signature_tv_cancel = getView().findViewById(R.id.frag_signature_tv_cancel);
        frag_signature_tv_signature.setText("Signature");


        RotateAnimation rotate= (RotateAnimation) AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_animation);
        frag_signature_tv_signature.setAnimation(rotate);

        frag_signature_tv_ok.setOnClickListener(this);
        frag_signature_tv_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.frag_signature_tv_cancel:
                Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
                break;
            case R.id.frag_signature_tv_ok:
                Fragment fragment = new ThankYou();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content,fragment);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;

                default:
                    break;
        }
    }
}
