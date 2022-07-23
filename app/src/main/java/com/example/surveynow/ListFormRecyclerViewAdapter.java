package com.example.surveynow;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.surveynow.model.Form;

import java.util.ArrayList;

public class ListFormRecyclerViewAdapter extends RecyclerView.Adapter<ListFormRecyclerViewAdapter.MyViewHolder>
{
    private final String Tag = "ListFormRecyclerViewAdapter";

    public Context context;
    public ArrayList<Form> forms;

    public ListFormRecyclerViewAdapter(Context context, ArrayList<Form> forms) {
        this.context = context;
        this.forms = forms;
        Log.d(Tag, "Constructor");
        Log.d(Tag, "context : " + context.toString());
        Log.d(Tag, "forms : " + forms.toString());
    }

    @NonNull
    @Override
    public ListFormRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(Tag, "Method OnCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.recycler_view_row_list_form, parent, false);

        return new ListFormRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFormRecyclerViewAdapter.MyViewHolder holder, int position) {
        Log.d(Tag, "onBing Method");

        holder.tvFormName.setText(forms.get(position).getName());
        holder.tvFormDescription.setText(forms.get(position).getDescription());
        holder.tvFormAuthor.setText(new StringBuilder().append("par ").append(forms.get(position).getAuthor()).toString());
        holder.tvFormCreatedAt.setText(new StringBuilder().append("Crée le ").append(forms.get(position).getCreatedAt().toString()).toString());
    }

    @Override
    public int getItemCount() {
        Log.d(Tag, "Size : " + String.valueOf(forms.size()));
        return forms.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private final String Tag = "ListFormRecyclerViewAdapter.MyViewHolder";

        public Button btnForm;
        public TextView tvFormName, tvFormDescription, tvFormCreatedAt, tvFormAuthor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            btnForm = itemView.findViewById(R.id.btnForm);
            tvFormName = itemView.findViewById(R.id.titleForm);
            tvFormDescription = itemView.findViewById(R.id.descriptionForm);
            tvFormCreatedAt = itemView.findViewById(R.id.createdAtForm);
            tvFormAuthor = itemView.findViewById(R.id.authorForm);

            Log.d(Tag, "Constructor");

        }

    }
}
