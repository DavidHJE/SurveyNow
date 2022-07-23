package com.example.surveynow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.surveynow.model.Form;

import java.util.ArrayList;

public class ListFormRecyclerViewAdapter extends RecyclerView.Adapter<ListFormRecyclerViewAdapter.MyViewHolder>
{
    private ArrayList<Form> forms;
    private OnListFormListener onListFormListener;

    public ListFormRecyclerViewAdapter(ArrayList<Form> forms, OnListFormListener onListFormListener) {
        this.forms = forms;
        this.onListFormListener = onListFormListener;
    }

    @NonNull
    @Override
    public ListFormRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_row_list_form, parent, false);

        return new ListFormRecyclerViewAdapter.MyViewHolder(view, this.onListFormListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFormRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvFormName.setText(forms.get(position).getName());
        holder.tvFormDescription.setText(forms.get(position).getDescription());
        holder.tvFormAuthor.setText(new StringBuilder().append("par ").append(forms.get(position).getAuthor()).toString());
        holder.tvFormCreatedAt.setText(new StringBuilder().append("Crée le ").append(forms.get(position).getCreatedAt().toString()).toString());
    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView tvFormName, tvFormDescription, tvFormCreatedAt, tvFormAuthor;
        public OnListFormListener onListFormListener;

        public MyViewHolder(@NonNull View itemView, OnListFormListener onListFormListener)  {
            super(itemView);

            this.onListFormListener = onListFormListener;

            tvFormName = itemView.findViewById(R.id.titleForm);
            tvFormDescription = itemView.findViewById(R.id.descriptionForm);
            tvFormCreatedAt = itemView.findViewById(R.id.createdAtForm);
            tvFormAuthor = itemView.findViewById(R.id.authorForm);

            itemView.findViewById(R.id.btnForm).setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onListFormListener.onListFormClick(getAdapterPosition());
        }
    }

    public interface OnListFormListener {
        public void onListFormClick(int position);
    }
}
