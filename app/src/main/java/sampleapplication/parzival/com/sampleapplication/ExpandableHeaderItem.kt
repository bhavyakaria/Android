package sampleapplication.parzival.com.sampleapplication

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_expandable_header.*

class ExpandableHeaderItem {
    class ExpandableHeaderItem(private val title: String)
        : Item(), ExpandableItem {

        override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.ViewHolder, position: Int) {
            viewHolder.item_expandable_header_title.text = title

            viewHolder.item_expandable_header_root.setOnClickListener {
                expandableGroup.onToggleExpanded()
            }
        }

        private lateinit var expandableGroup: ExpandableGroup

        override fun getLayout() = R.layout.item_expandable_header

        override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
            expandableGroup = onToggleListener
        }

    }
}