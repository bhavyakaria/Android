package sampleapplication.parzival.com.sampleapplication.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sampleapplication.parzival.com.sampleapplication.R;
import sampleapplication.parzival.com.sampleapplication.java.adapter.RecyclerViewJavaAdapter;
import sampleapplication.parzival.com.sampleapplication.java.model.Person;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecyclerViewJavaActivity extends AppCompatActivity implements RecyclerViewJavaAdapter.ClickListener {

    List<Person> mPersonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_java);

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

    }

    private void addPersonData() {
        mPersonList.add(new Person("Elon Musk","elonmusk@tesla.com"));
        mPersonList.add(new Person("Bill Gates","billgates@microsoft.com"));
        mPersonList.add(new Person("Mark Zuckerberg","mark@facebook.com"));
        mPersonList.add(new Person("Steve Jobs","jobs@apple.com"));
        mPersonList.add(new Person("Larry Page","larry@google.com"));
        mPersonList.add(new Person("Sunder Pichai","sundar@google.com"));
    }

    @Override
    public void onProfileClick(Person person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked Profile!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNameClick(Person person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked User Name!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRowClick(Person person, View v) {
        Toast.makeText(getApplicationContext(),"Clicked Row!",Toast.LENGTH_SHORT).show();
    }
}
