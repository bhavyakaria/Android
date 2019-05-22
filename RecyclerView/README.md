
# Recycler View
Step by step guide for implementing Simple Recycler View.

## Dependencies
```
implementation 'androidx.recyclerview:recyclerview:1.0.0'
```

## Steps
1. Add RecyclerView component to the XML layout
```
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:listitem="@android:layout/activity_list_item" />
```

2. Create a model class for data to be shown in RecyclerView
```
public class Person {
    String userName;
    String userEmail;

    public Person(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
```

3. Create an XML for row layout in the RecyclerView
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/layout_row"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/image_user_profile"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_margin="16dp"
        android:src="@mipmap/ic_launcher"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/text_user_name"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="16dp"
        android:text="User Name"
        android:textSize="18sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/image_user_profile"
        app:layout_constraintTop_toTopOf="@+id/image_user_profile" />

    <TextView
        android:id="@+id/text_user_email"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:text="TextView"
        app:layout_constraintBottom_toBottomOf="@+id/image_user_profile"
        app:layout_constraintStart_toEndOf="@+id/image_user_profile"
        app:layout_constraintTop_toBottomOf="@+id/text_user_name"
        app:layout_constraintVertical_bias="1.0" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

4. Create a Adapter with ClickListener interface
```
public class RecyclerViewJavaAdapter extends RecyclerView.Adapter<RecyclerViewJavaAdapter.MyViewHolder> {

    // List of Persons to be shown in RecyclerView
    public static List<Person> mPersonList;

    // ClickListener for RecyclerView row layout
    public static ClickListener mClickListener;


    // Constructor for setting person list and initializing click listener
    // Note: We do not need to pass context
    public RecyclerViewJavaAdapter(List<Person> personList, ClickListener clickListener) {
        mPersonList = personList;
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize the LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the view with the row layout xml that we have created
        View listItem= layoutInflater.inflate(R.layout.item_person, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // bind the person in the list to the view 
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

    // ClickListener interface with methods for detecting clicks in the activity
    public interface ClickListener {
        void onProfileClick(Person person, View v);
        void onUserNameClick(Person person, View v);
        void onRowClick(Person person, View v);
    }
}
```

5. Combine all together in the activity
```
// add data in the mPersonList
addPersonData();

RecyclerView recyclerView = findViewById(R.id.recycler_view);

// set layout manager
LinearLayoutManager layoutManager = new LinearLayoutManager(this);
recyclerView.setLayoutManager(layoutManager);

// set divider between two rows
DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
recyclerView.addItemDecoration(divider);

// set adapter
RecyclerViewJavaAdapter adapter = new RecyclerViewJavaAdapter(mPersonList,this);
recyclerView.setAdapter(adapter);
```
