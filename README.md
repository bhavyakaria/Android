# Anko Commons Library
Step by step guide for using Anko Commons library with Kotlin.

## Dependencies
```groovy
// anko commons
implementation "org.jetbrains.anko:anko:0.10.8"

// required for snackbar
implementation "org.jetbrains.anko:anko-design:0.10.8"
```

## Benefits of using it
1. Writing less lines of code. Remove boilerplate code.

```kotlin
// Without Anko
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("id", 1)
intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
startActivity(this, intent)

// With Anko
startActivity(intentFor<SecondActivity>("id" to 1).singleTop())
``` 

## Things to remember
* If you only need some of the features, then refer to that particular part of the library and don't reference the meta-dependency which plugs in all available features.  




