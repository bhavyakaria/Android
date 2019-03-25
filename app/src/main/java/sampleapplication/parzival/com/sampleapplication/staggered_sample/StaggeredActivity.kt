package sampleapplication.parzival.com.sampleapplication.staggered_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_staggered.*
import sampleapplication.parzival.com.sampleapplication.R

class StaggeredActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered)

        var list = listOf(R.drawable.large,R.drawable.small,R.drawable.small,R.drawable.small,R.drawable.small,R.drawable.large)


        // layout manager
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        recycler_view.layoutManager = layoutManager
        val adapter = StaggeredAdapter(this,list)
        recycler_view.adapter = adapter
    }
}
