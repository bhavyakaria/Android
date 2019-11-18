package com.bhavyakaria.retrofitrxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhavyakaria.retrofitrxjava.networking.ApiClient;
import com.bhavyakaria.retrofitrxjava.networking.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsFeedsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        // make api call using retrofit and handle response using rxjava
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService.getHeadlines(BuildConfig.NewsApiKey, "business", "in")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    val -> {
                        adapter = new NewsFeedsAdapter(val.getArticles(), this);
                        recyclerView.setAdapter(adapter);
                    },
                    err -> {

                    },
                    () -> Log.d("Parzival", "Completed")
                    );
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_news_feeds);

        // set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}
