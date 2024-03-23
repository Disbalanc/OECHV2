package com.example.oech.Profile.ui.track;

import android.content.Context;
import android.media.RouteListingPreference;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oech.R;

import java.util.List;
import java.util.Stack;

public class MyAppData extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item> items;

    public MyAppData(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public int getItemViewType(int position)
    {
        return position;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_two, parent, false));
        }
        else if (viewType == 0 || viewType == 1 || viewType > 2) {
            return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (this.getItemViewType(position) == 2) {
            holder.textViewTitle.setText((CharSequence) items.get(position).getTitle());
            holder.editTextOne.setHint((CharSequence) items.get(position).getAddress());
            holder.editTextTwo.setHint((CharSequence) items.get(position).getState());
            holder.editTextThree.setHint((CharSequence) items.get(position).getPhone());

            //holder.get;
        }
        else if (this.getItemViewType(position) == 0 ||
                 this.getItemViewType(position) == 1 ||
                 this.getItemViewType(position) > 2) {
            holder.textViewTitle.setText((CharSequence) items.get(position).getTitle());
            holder.editTextOne.setHint((CharSequence) items.get(position).getAddress());
            holder.editTextTwo.setHint((CharSequence) items.get(position).getState());
            holder.editTextThree.setHint((CharSequence) items.get(position).getPhone());
            holder.editTextFour.setHint((CharSequence) items.get(position).getOthers());

            items.get(position).setDataTitleTitle(String.valueOf(holder.editTextOne.getText()));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

