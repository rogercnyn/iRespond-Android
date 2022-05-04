package com.example.irespond;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostRVAdapter extends RecyclerView.Adapter<PostRVAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<PostModal> postModalArrayList;
    private Context context;

    // constructor
    public PostRVAdapter(ArrayList<PostModal> postModalArrayList, Context context) {
        this.postModalArrayList = postModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        PostModal modal = postModalArrayList.get(position);
        holder.username.setText(modal.getUsername());
        holder.content.setText(modal.getContent());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return postModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView username, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            username = itemView.findViewById(R.id.usernamedisplay);
            content = itemView.findViewById(R.id.storydisplay);
        }
    }
}
