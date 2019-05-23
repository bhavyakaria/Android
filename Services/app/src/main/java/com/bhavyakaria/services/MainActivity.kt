package com.bhavyakaria.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bhavyakaria.services.java.ServicesJavaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_java.setOnClickListener {
            startActivity(Intent(applicationContext, ServicesJavaActivity::class.java))
        }

        btn_kotlin.setOnClickListener {
            //startActivity(Intent(applicationContext, ))
        }
    }
}
