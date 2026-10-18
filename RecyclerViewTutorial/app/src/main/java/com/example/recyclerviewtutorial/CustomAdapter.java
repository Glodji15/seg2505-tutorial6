package com.example.recyclerviewtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] localDataSet;

    // Store the data to display.
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Hold the views of each list item.
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    // Create a new view for a list item.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    // Display the data at the given position.
    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        holder.getTextView().setText(localDataSet[position]);
    }

    // Return the number of items.
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
