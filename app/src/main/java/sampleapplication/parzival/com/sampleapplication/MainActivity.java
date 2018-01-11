package sampleapplication.parzival.com.sampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Level 0");
        listDataHeader.add("Level 1");
        listDataHeader.add("Level 2");

        // Adding child data
        List<String> top250 = new ArrayList<>();
        top250.add("Complete exercise 1");
        top250.add("Complete exercise 2");
        top250.add("Complete exercise 3");
        top250.add("Complete exercise 4");
        top250.add("Complete exercise 5");
        top250.add("Complete exercise 6");
        top250.add("Complete exercise 7");

        List<String> nowShowing = new ArrayList<>();
        nowShowing.add("Complete exercise 1");
        nowShowing.add("Complete exercise 2");
        nowShowing.add("Complete exercise 3");
        nowShowing.add("Complete exercise 4");
        nowShowing.add("Complete exercise 5");
        nowShowing.add("Complete exercise 6");

        List<String> comingSoon = new ArrayList<>();
        comingSoon.add("Complete exercise 1");
        comingSoon.add("Complete exercise 2");
        comingSoon.add("Complete exercise 3");
        comingSoon.add("Complete exercise 4");
        comingSoon.add("Complete exercise 5");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
