package com.bhavyakaria.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhavyakaria.com.sampleapplication.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent.let {
            txt_id.text = it.getIntExtra("id",0).toString()
            txt_city.text = it.getStringExtra("city")
            txt_state.text = it.getStringExtra("state")
        }
    }
}
