# Retrofit + RxJava

This project contains an example of using rxjava with retrofit. Retrofit is used for making the network call and then the response is handled with rxjava.

## Build Instructions:

1. Clone the project

2. Get your API key from [News API](https://newsapi.org/) and add it to build.gradle(app) file

```gradle
buildConfigField("String", "NewsApiKey", "\"API_KEY_HERE\"")
```

3. Rebuild the project and you are good to go.

## Dependencies

```gradle
// retorfit + rxjava
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
implementation 'com.squareup.okhttp3:logging-interceptor:3.12.0'
implementation 'com.squareup.retrofit2:converter-scalars:2.1.0'
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'
implementation 'io.reactivex.rxjava2:rxjava:2.1.13'
implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'

// glide
implementation 'com.github.bumptech.glide:glide:4.10.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.10.0'
```

