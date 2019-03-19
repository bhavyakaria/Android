package sampleapplication.parzival.com.sampleapplication

import androidx.annotation.ColorInt
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_fancy.*

class FancyItem(@ColorInt private val color : Int,
                private val number : Int) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.item_fancy_cardView.setCardBackgroundColor(color)
        viewHolder.item_fancy_number.text = number.toString()
    }

    override fun getLayout() = R.layout.item_fancy

    override fun getSpanSize(spanCount: Int, position: Int) = spanCount/2
}