package com.bhavyakaria.retrofitrxjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhavyakaria.retrofitrxjava.models.ArticleResponseWrapper;
import com.bhavyakaria.retrofitrxjava.networking.ApiClient;
import com.bhavyakaria.retrofitrxjava.networking.ApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsFeedsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_news_feeds);

        // set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiService apiService = ApiClient.getClientWithoutAuth().create(ApiService.class);

        Observable<ArticleResponseWrapper> call = apiService.getHeadlines("9dc512c432a94ef29d6bfe3d0e699148", "business", "in");
        call.subscribeOn(Schedulers.io())
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

    private void handleResults(ArticleResponseWrapper articleResponseWrapper){

    }

    private void handleError(Throwable t){
        Toast.makeText(this, "ERROR IN FETCHING API RESPONSE. Try again",
                Toast.LENGTH_LONG).show();
    }
}
