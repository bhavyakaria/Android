package sampleapplication.parzival.com.sampleapplication.asymmetricgrid_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import sampleapplication.parzival.com.sampleapplication.R
import kotlinx.android.synthetic.main.activity_asymmetric_grid.*
import sampleapplication.parzival.com.sampleapplication.SpannedGridLayoutManager


class AsymmetricGridActivity : AppCompatActivity() {

    var list = listOf(R.drawable.large,R.drawable.small,R.drawable.small,R.drawable.small,R.drawable.small,R.drawable.large)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asymmetric_grid)

        val mng_layout = GridLayoutManager(applicationContext, 4,GridLayoutManager.HORIZONTAL,false)

        val adapter = AsymmetricGridAdapter(applicationContext, list)
        recycler_view.adapter = adapter


        mng_layout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if(position % 5 == 0) {
                    return 4
                } else {
                    return 2
                }
            }
        }
        recycler_view.layoutManager = mng_layout
    }
}
