package com.example.surveynow.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.surveynow.R;
import com.example.surveynow.model.Form;

public class DetailFormFragment extends Fragment {

    private static final String ARG_PARAM1 = "form";

    private Form form;

    public DetailFormFragment() {
        // Required empty public constructor
    }

    public static DetailFormFragment newInstance(String form) {
        DetailFormFragment fragment = new DetailFormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, form);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            form = (Form) getArguments().get(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_form, container, false);
    }
}