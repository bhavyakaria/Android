package com.bhavyakaria.recyclerview.java.staggered_grid_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bhavyakaria.recyclerview.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.List;

public class RecyclerViewJavaAdapter extends RecyclerView.Adapter<RecyclerViewJavaAdapter.MyViewHolder> {

    // Using Glide without context in adapter
    private final RequestManager glide;

    // List of Persons to be shown in RecyclerView
    public static List<PersonModel> mPersonList;

    // ClickListener for RecyclerView row layout
    public static ClickListener mClickListener;


    // Constructor for setting person list and initializing click listener
    // Note: We do not need to pass context
    public RecyclerViewJavaAdapter(List<PersonModel> personList, ClickListener clickListener, RequestManager glide) {
        mPersonList = personList;
        mClickListener = clickListener;
        this.glide = glide;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize the LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the view with the row layout xml that we have created
        View listItem= layoutInflater.inflate(R.layout.staggered_row_layouot, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // bind the person in the list to the view
        final PersonModel person = mPersonList.get(position);
        //holder.mUserName.setText(person.getUserName());
        //holder.mUserEmail.setText(person.getUserEmail());
        glide.load(person.imageUrl).into(holder.mUserProfile);

    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // all the views in our row layout
        public ImageView mUserProfile;
        public TextView mUserName;
        public TextView mUserEmail;
        public ConstraintLayout mRowLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mRowLayout = itemView.findViewById(R.id.layout_row);
            mUserProfile = itemView.findViewById(R.id.image_user_profile);
            mUserName = itemView.findViewById(R.id.text_user_name);
            mUserEmail = itemView.findViewById(R.id.text_user_email);

            mUserProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onProfileClick(mPersonList.get(getAdapterPosition()), v);
                }
            });

        }
    }

    // ClickListener interface with methods for detecting clicks in the activity
    public interface ClickListener {
        void onProfileClick(PersonModel person, View v);
        void onUserNameClick(PersonModel person, View v);
        void onRowClick(PersonModel person, View v);
    }
}