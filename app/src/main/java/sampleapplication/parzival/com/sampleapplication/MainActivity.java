package sampleapplication.parzival.com.sampleapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CustomFragmentAdapter customFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        customFragmentAdapter = new CustomFragmentAdapter(getSupportFragmentManager());

        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        CustomFragmentAdapter adapter = new CustomFragmentAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentOne(), "Fragment One");
        adapter.addFragment(new FragmentTwo(), "Fragment Two");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }
}
