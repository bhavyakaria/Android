# Android
Step by step guide for various components in android

# Expandable List View

1. Add ExpandableListView to your activity layout file.
```
<ExpandableListView
        android:id="@+id/lvExp"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"/>
```

2. Create **list_group.xml**(Header) and **list_item.xml**(List Items)

**list_group.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="50dp"
    android:orientation="vertical"
    android:padding="20dp"
    android:background="#f7f7f7">
    
    <TextView
        android:id="@+id/lblListHeader"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingLeft="?android:attr/expandableListPreferredItemPaddingLeft"
        android:textSize="18sp"
        android:textColor="#000000"
        android:textStyle="normal"
        android:textAllCaps="true"/>

</LinearLayout>
```

**list_item.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/lblListItem"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:paddingTop="15dp"
        android:paddingBottom="15dp"
        android:paddingLeft="?android:attr/expandableListPreferredChildPaddingLeft" />
</LinearLayout>
```

3. Create an adapter in **ExpandableListAdapter.java** which extends BaseExpandableListAdapter
```
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild =  convertView.findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
```

4. Connecting all the pieces together
```
// get the listview
expListView = (ExpandableListView) findViewById(R.id.lvExp);

// preparing list data
prepareListData();

listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

// setting list adapter
expListView.setAdapter(listAdapter);
```

5. Adding content to the list
```
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
```

6. Adding Listener on the list.
```
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
```
