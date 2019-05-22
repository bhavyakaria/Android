package com.bhavyakaria.recyclerview.java.staggered_grid_recycler_view;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bhavyakaria.recyclerview.R;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class StaggeredGridRecyclerViewActivity extends AppCompatActivity implements RecyclerViewJavaAdapter.ClickListener {

    List<PersonModel> personModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_recycler_view);

        RecyclerView simpleRecyclerView = findViewById(R.id.recycler_view_staggered);

        // add data in the mPersonList
        addPersonData();


        // set layout manager
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        simpleRecyclerView.setLayoutManager(gridLayoutManager);

        // set adapter
        RecyclerViewJavaAdapter adapter = new RecyclerViewJavaAdapter(personModelList,this, Glide.with(this));
        simpleRecyclerView.setAdapter(adapter);

    }

    private void addPersonData() {
        personModelList.add(new PersonModel("Elon Musk","elonmusk@tesla.com", "https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.iWIrJLgsFjMT1WjrPAUb1QHaEc%26pid%3DApi&f=1"));
        personModelList.add(new PersonModel("Bill Gates","billgates@microsoft.com", "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fimages2.fanpop.com%2Fimages%2Fphotos%2F8300000%2FGraz-austria-8371031-1920-2560.jpg&f=1"));
        personModelList.add(new PersonModel("Mark Zuckerberg","mark@facebook.com", "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.esa.int%2Fvar%2Fesa%2Fstorage%2Fimages%2Fesa_multimedia%2Fimages%2F2015%2F11%2Fmontreal_canada%2F15672175-2-eng-GB%2FMontreal_Canada.jpg&f=1"));
        personModelList.add(new PersonModel("Steve Jobs","jobs@apple.com", "https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.nikonians.org%2Fwebsite%2Fvar%2Fassets%2Fres%2Fimages%2F2016_04%2F20160422_151856_bird-d500-dhmiller-iso1600-329740.jpg&f=1"));
        personModelList.add(new PersonModel("Larry Page","larry@google.com", "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.esa.int%2Fvar%2Fesa%2Fstorage%2Fimages%2Fesa_multimedia%2Fimages%2F2016%2F10%2Fcolima_volcano%2F16186851-1-eng-GB%2FColima_volcano.jpg&f=1"));
        personModelList.add(new PersonModel("Sunder Pichai","sundar@google.com", "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.esa.int%2Fvar%2Fesa%2Fstorage%2Fimages%2Fesa_multimedia%2Fimages%2F2016%2F10%2Fcolima_volcano%2F16186851-1-eng-GB%2FColima_volcano.jpg&f=1"));
    }


    @Override
    public void onProfileClick(PersonModel person, View v) {

    }

    @Override
    public void onUserNameClick(PersonModel person, View v) {

    }

    @Override
    public void onRowClick(PersonModel person, View v) {

    }
}
