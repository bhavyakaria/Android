package sampleapplication.parzival.com.sampleapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateAdapter()

        recycler_view.apply {

            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.HORIZONTAL, false)
            adapter = groupAdapter
        }

    }

    private fun populateAdapter() {

        val boringFancyItem = generateFancyItems(6)
        val section = Section()
        section.addAll(boringFancyItem)
        groupAdapter.add(section)

    }

    fun generateFancyItems(count : Int) : MutableList<FancyItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(255, rnd.nextInt(256),
                        rnd.nextInt(256), rnd.nextInt(256))
            FancyItem(color, rnd.nextInt(100))
        }
    }
}
