# Services

## What are services?
* A service is a component which runs in the background without interacting with the user. 
* It has no interface and is not bound to the lifecycle of an activity.
* They are generally used for long running operations i.e. Internet downloads, checking new data, updating content providers and like.
* Even on closing or crashing of app, the services keep on running. They have a higher priority.
* By default, a service runs in the same process as the main thread of the application.
* Therefore, you need to use asynchronous processing for resource intensive tasks in the background.
* The Android platform has predefined system services and every Android application can use them via `getSystemService()` method.
* To create a service, you create a Java class that extends the Service base class or one of  its existing subclasses.

## States of services
1. **Started**
A service can be started from an application component, such as an activity, by calling `startService()`. It can run in background indefinitely even if the component that started  it is destroyed.
2. **Bound**
A service is bound when an application component binds to it by calling `bindService()`.


## Step to step guide on creating a service
1. Create a Service class by extending the Service base class.
```java
public class SampleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Service Destroyed", Toast.LENGTH_SHORT).show();
    }
}
```
Here, `START_STICKY` is the code which is  relevant when the phone runs out of memory and kills the service.
1. **START_STICKY**: Tells the OS to recreate the service with a null intent when OS has regained sufficient memory.
2. **START_NOT_STICKY**: Tells OS to not bother recreating the service.
3. **START_REDELIVER_INTENT**: Tells OS to recreate the service and redeliver the same intent to `onStartCommand()`.

2. In the MainActivity:
```java
startService.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // start the service from SampleService class
        startService(new Intent(getBaseContext(), SampleService.class));
    }
});

stopService.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // stop the service from SampleService class
        stopService(new Intent(getBaseContext(), SampleService.class));
    }
});
```

3. Add Service to the `AndroidManifest.xml` file.
```xml
<service android:name=".java.SampleService"/>
```

4. Run the  application.
