package sampleapplication.parzival.com.sampleapplication;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    private Button btn_one;
    LoaderManager mLoaderManager;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_one = findViewById(R.id.btn_one);
        txt = findViewById(R.id.text);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if (mLoaderManager.getLoader(1) != null) {
            mLoaderManager.initLoader(1, null, this); // deliver result after screen rotation
        }
    }

    public void startMyAsyncTask(View view) {
        mLoaderManager.initLoader(1,null,this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            public String loadInBackground() {
                //Think of this as AsyncTask doInBackground() method, here you will actually initiate Network call, or any work that need to be done on background
                for (int i=0; i<=100; i++) {
                    try {
                        Thread.sleep(50);
                        Log.d("Parzival","loadInBackground: "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return "Task Result";
            }

            @Override
            protected void onStartLoading() {
                //Think of this as AsyncTask onPreExecute() method,you can start your progress bar,and at the end call forceLoad();
                forceLoad();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        txt.setVisibility(View.VISIBLE);
        txt.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
