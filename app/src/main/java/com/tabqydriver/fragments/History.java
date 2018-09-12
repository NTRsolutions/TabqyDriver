package com.tabqydriver.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tabqydriver.R;
import com.tabqydriver.adapters.EarnAdapter;
import com.tabqydriver.adapters.HistoryAdapter;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class History extends Fragment implements View.OnClickListener, HistoryAdapter.HistoryInterface {

    private TextView frag_history_tv_go;
    private RecyclerView history_recycler;
    private int mYear, mMonth, mDay;
    private LinearLayout frag_history_lin_calender1,frag_history_lin_calender2;
    private TextView frag_history_tv_calender1,frag_history_tv_calender2;

    public History() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    public void init(){
        frag_history_tv_go = getView().findViewById(R.id.frag_history_tv_go);

        frag_history_lin_calender1 = getView().findViewById(R.id.frag_history_lin_calender1);
        frag_history_lin_calender2 = getView().findViewById(R.id.frag_history_lin_calender2);

        frag_history_lin_calender1.setOnClickListener(this);
        frag_history_lin_calender2.setOnClickListener(this);

        frag_history_tv_calender1 = getView().findViewById(R.id.frag_history_tv_calender1);
        frag_history_tv_calender2 = getView().findViewById(R.id.frag_history_tv_calender2);

        history_recycler = getView().findViewById(R.id.history_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        history_recycler.setLayoutManager(linearLayoutManager);
        setAdapter();
        frag_history_tv_go.setOnClickListener(this);
    }

    private void setAdapter() {
        HistoryAdapter historyAdapter = new HistoryAdapter(getActivity(),this);
        history_recycler.setAdapter(historyAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.frag_history_tv_go) {
            history_recycler.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.frag_history_lin_calender1) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    frag_history_tv_calender1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (view.getId() == R.id.frag_history_lin_calender2) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    frag_history_tv_calender2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    @Override
    public void getDetails(int position) {

    }
}
