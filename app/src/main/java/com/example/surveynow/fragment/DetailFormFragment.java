package com.example.surveynow.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.surveynow.R;
import com.example.surveynow.databinding.FragmentDetailFormBinding;
import com.example.surveynow.model.Form;

public class DetailFormFragment extends Fragment {

    private static final String TAG = "DetailFormFragment";

    private FragmentDetailFormBinding binding;

    private Form form;

    public DetailFormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // inflater.inflate(R.layout.fragment_detail_form, container, false);

        binding = FragmentDetailFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        form = DetailFormFragmentArgs.fromBundle(getArguments()).getForm();

        binding.tvTitleForm.setText(form.getName());
        binding.tvDescriptionForm.setText(form.getDescription());
        binding.tvCreatedAtForm.setText("Creer le " + form.getCreatedAt().toString());
        binding.tvAuthorForm.setText("par " + form.getName());
    }
}