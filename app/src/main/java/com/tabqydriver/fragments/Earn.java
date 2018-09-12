package com.tabqydriver.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tabqydriver.R;
import com.tabqydriver.adapters.EarnAdapter;
import com.tabqydriver.adapters.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Earn extends Fragment implements EarnAdapter.EarnInterface {

    private RecyclerView earn_recycler;

    public Earn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_earn, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    public void init(){
        earn_recycler = getView().findViewById(R.id.earn_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        earn_recycler.setLayoutManager(linearLayoutManager);
        setAdapter();
    }

    public void setAdapter(){
        EarnAdapter homeAdapter = new EarnAdapter(getActivity(),this);
        earn_recycler.setAdapter(homeAdapter);
    }

    @Override
    public void getDetails(int position) {

    }
}
