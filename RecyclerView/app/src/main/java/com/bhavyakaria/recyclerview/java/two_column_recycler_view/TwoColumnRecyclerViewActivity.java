package com.bhavyakaria.recyclerview.java.two_column_recycler_view;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bhavyakaria.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class TwoColumnRecyclerViewActivity extends AppCompatActivity implements RecyclerViewJavaAdapter.ClickListener {

    List<PersonModel> personModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_column_recycler_view);

        RecyclerView simpleRecyclerView = findViewById(R.id.two_column_recycler_view);

        // add data in the mPersonList
        addPersonData();


        // set layout manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        simpleRecyclerView.setLayoutManager(gridLayoutManager);

        // set adapter
        RecyclerViewJavaAdapter adapter = new RecyclerViewJavaAdapter(personModelList,this);
        simpleRecyclerView.setAdapter(adapter);

    }

    private void addPersonData() {
        personModelList.add(new PersonModel("Elon Musk","elonmusk@tesla.com"));
        personModelList.add(new PersonModel("Bill Gates","billgates@microsoft.com"));
        personModelList.add(new PersonModel("Mark Zuckerberg","mark@facebook.com"));
        personModelList.add(new PersonModel("Steve Jobs","jobs@apple.com"));
        personModelList.add(new PersonModel("Larry Page","larry@google.com"));
        personModelList.add(new PersonModel("Sunder Pichai","sundar@google.com"));
    }

    @Override
    public void onProfileClick(PersonModel person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked Profile!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNameClick(PersonModel person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked User Name!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRowClick(PersonModel person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked Row!",Toast.LENGTH_SHORT).show();
    }
}
