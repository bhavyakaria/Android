package sampleapplication.parzival.com.sampleapplication.java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import sampleapplication.parzival.com.sampleapplication.R;
import sampleapplication.parzival.com.sampleapplication.java.model.Person;

public class RecyclerViewJavaAdapter extends RecyclerView.Adapter<RecyclerViewJavaAdapter.MyViewHolder> {

    public static List<Person> mPersonList;
    public static ClickListener mClickListener;


    public RecyclerViewJavaAdapter(List<Person> personList, ClickListener clickListener) {
        mPersonList = personList;
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_person, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Person person = mPersonList.get(position);
        holder.mUserName.setText(person.getUserName());
        holder.mUserEmail.setText(person.getUserEmail());
        //holder.mUserProfile.setImageDrawable(person.getUserProfile());

    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

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

            mUserName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onUserNameClick(mPersonList.get(getAdapterPosition()),v);
                }
            });

            mRowLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onRowClick(mPersonList.get(getAdapterPosition()),v);
                }
            });
        }
    }

    public interface ClickListener {
        void onProfileClick(Person person, View v);
        void onUserNameClick(Person person, View v);
        void onRowClick(Person person, View v);
    }
}
