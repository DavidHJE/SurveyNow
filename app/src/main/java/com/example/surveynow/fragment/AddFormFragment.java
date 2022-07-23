package com.example.surveynow.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.surveynow.R;
import com.example.surveynow.databinding.FragmentAddFormBinding;
import com.example.surveynow.databinding.FragmentSecondBinding;
import com.example.surveynow.model.Form;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFormFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentAddFormBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final String Tag = "AddFormFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFormFragment newInstance(String param1, String param2) {
        AddFormFragment fragment = new AddFormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // inflater.inflate(R.layout.fragment_add_form, container, false);

        binding = FragmentAddFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAddForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateFormView()) {
                    return;
                }

                Form form = getFormFromView();

                Map<String, Object> newForm = new HashMap<>();
                newForm.put("name", form.getName());
                newForm.put("description", form.getDescription());
                newForm.put("author", form.getAuthor());
                newForm.put("createdAt", form.getCreatedAt());

                db.collection(Form.FIREBASE_COLLECTION)
                        .add(newForm)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getContext(), "Formulaire crée", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(), "Formulaire n'a pas pu etre créer", Toast.LENGTH_SHORT).show();
                            }
                        });

/*
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
 */
            }
        });


    }

    /**
     * Builds a Form class
     *
     * @return a Form Class
     */
    private Form getFormFromView() {
        Form form = new Form();
        form.setName(binding.nameAddForm.getText().toString());
        form.setDescription(binding.descriptionAddForm.getText().toString());
        form.setAuthor(binding.authorAddForm.getText().toString());
        form.setCreatedAt(Calendar.getInstance().getTime());

        return form;
    }

    /**
     * Check that the form is correctly completed
     *
     * @return true if the form is valid or elseif
     */
    private Boolean validateFormView() {
        if (TextUtils.isEmpty(binding.nameAddForm.getText().toString())) {
            Toast.makeText(getContext(), "Nom vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(binding.descriptionAddForm.getText().toString())) {
            Toast.makeText(getContext(), "Description vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(binding.authorAddForm.getText().toString())) {
            Toast.makeText(getContext(), "Auteur vide", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}