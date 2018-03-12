package sampleapplication.parzival.com.sampleapplication;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

/**
 * Created by Parzival on 11-03-2018.
 */

public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
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
        forceLoad();
    }
}
