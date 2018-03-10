# Android
Step by step guide for various components in android

# Fragment Component

### Dependencies
None to be added. 

### Basic Structure
1. MainActivity
2. Fragments
3. Custom Adapter

### Steps

1. Add ViewPager to your **activity_layout file**.

``` 
<android.support.v4.view.ViewPager
   android:id="@+id/viewPager"
   android:layout_width="match_parent"
   android:layout_height="match_parent"/>
```

2. Create a **layout files** for fragments.

3. Create a CustomeAdapter which extends FragmentStatePagerAdapter

```
public class CustomFragmentAdapter extends FragmentStatePagerAdapter {

    // ArrayList to store the fragments and its  title
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitleList = new ArrayList<>();

    // Default Constructor (needed)
    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    // Adding fragments to the ArrayList
    // Needs to be public as called in Activity file.
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    // Returns the Fragment associated with a specified position. (needed)
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    // Returns the no. of fragments. (needed)
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

```

4. Create Fragment files

```
public class FragmentOne extends Fragment {
    private Button btn1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Just  like setContentView in Activity
        View view  = inflater.inflate(R.layout.fragment_one_layout, container, false);

        //findViewById needs to add view
        btn1 = view.findViewById(R.id.btn_one);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        return view;
    }
}

```

5. Create setupViewPager and setViewPager methods in **MainActivity**

```
private void setupViewPager(ViewPager viewPager) {
  CustomFragmentAdapter adapter = new CustomFragmentAdapter(getSupportFragmentManager());

  adapter.addFragment(new FragmentOne(), "Fragment One");
  adapter.addFragment(new FragmentTwo(), "Fragment Two");
  viewPager.setAdapter(adapter);
}

// Needs to be public as its called in Fragment file.
public void setViewPager(int fragmentNumber) {
  viewPager.setCurrentItem(fragmentNumber);
}
```
