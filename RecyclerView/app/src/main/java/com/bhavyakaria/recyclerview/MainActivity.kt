package com.bhavyakaria.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhavyakaria.recyclerview.java.RecyclerViewJavaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_java.setOnClickListener {
            startActivity(Intent(applicationContext, RecyclerViewJavaActivity::class.java))
        }

        btn_kotlin.setOnClickListener {
            //startActivity(Intent(applicationContext, ))
        }
    }
}
