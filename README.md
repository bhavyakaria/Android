# Android
Step by step guide for various components in android

# Converting JSON to Java Model (Without GSON)

We will be using volley for network calls for fetching json from the following url:

URL : ```https://api.github.com/users```

1.Add following dependencies to **build.gradle**.

```
implementation 'com.android.volley:volley:1.1.0'
```

2.Create a Model Class.

```
public class ModelClass {

    private String userName;
    private long id;

    public String getUserName() {
        return userName;
    }


    public long getId() {
        return id;
    }
```

Then add a method in it to convert JsonObject to POJO.

```
public static ModelClass fromJsonOjectToModel(JSONObject jsonObject) {
        ModelClass m = new ModelClass();

        try {
            m.userName = jsonObject.getString("login");
            m.id = jsonObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return m;
    }
```

Now create one more method to convert JsonArray to JsonObject.

```
public static ArrayList<ModelClass> fromJsonArrayToJsonObject(JSONArray jsonArray) {

        JSONObject dataJson;
        ArrayList<ModelClass> data = new ArrayList<>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            try {
                dataJson = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }

            ModelClass business = ModelClass.fromJsonOjectToModel(dataJson);
            if (business != null) {
                data.add(business);
            }
        }
        return data;
}
```

3.Create a **AppSingleton.java** for creating a requestQueue which can be used throughout the application.

```
public class AppSingleton {
    private static AppSingleton mAppSingletonInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mContext;

    private AppSingleton(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized AppSingleton getInstance(Context context) {
        if (mAppSingletonInstance == null) {
            mAppSingletonInstance = new AppSingleton(context);
        }
        return mAppSingletonInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req,String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
```

4.Adding all the pieces together

```
public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://api.github.com/users";
    ArrayList<ModelClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String  REQUEST_TAG = "sampleapplication.parzival.com.sampleapplication";

        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                list = ModelClass.fromJsonArrayToJsonObject(response);

                for (int i=0; i < list.size(); i++ ) {
                    Log.d("Parzival",list.get(i).getUserName());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(request,REQUEST_TAG);


    }
}
```

### Note:
Network calls are carried on the secondary thread and not on the main thread. So the list will be empty outside the onResponse method 

## Screenshot:
![alt text](https://github.com/bhavyakaria/Android/blob/json_to_pojo/app/src/main/res/drawable/json_to_pojo.JPG "JsonToPojo")
