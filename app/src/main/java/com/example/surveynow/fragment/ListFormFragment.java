package com.example.surveynow.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.surveynow.ListFormRecyclerViewAdapter;
import com.example.surveynow.databinding.FragmentListFormBinding;
import com.example.surveynow.model.Form;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class ListFormFragment extends Fragment {

    private FragmentListFormBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final String Tag = "ListFormFragment";
    private ListFormRecyclerViewAdapter adapter;

    ArrayList<Form> forms = new ArrayList<>();

    public ListFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpArrayListForms();


    }

    public void setUpArrayListForms() {
        db.collection(Form.FIREBASE_COLLECTION)
                .orderBy("createdAt", Query.Direction.ASCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(Tag, document.getId() + " => " + document.getData());
                                if (!isDataComplete(document.getData())) {
                                    continue;
                                }

                                Form form = new Form();
                                form.setId(document.getId());
                                form.setName(document.getData().get("name").toString());
                                form.setDescription(document.getData().get("description").toString());
                                form.setAuthor(document.getData().get("author").toString());
                                form.setCreatedAt(((Timestamp) document.getData().get("createdAt")).toDate());

                                Log.d(Tag, form.toString());
                                forms.add(form);
                            }

                            adapter = new ListFormRecyclerViewAdapter(getContext(), forms);
                            binding.listFormRecyclerView.setAdapter(adapter);
                            binding.listFormRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        } else {
                            Log.w(Tag, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private Boolean isDataComplete(Map<String, Object> data) {
        return data.containsKey("name") && data.containsKey("description") && data.containsKey("author") && data.containsKey("createdAt");
    }
}