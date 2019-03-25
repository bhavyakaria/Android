package sampleapplication.parzival.com.sampleapplication.staggered_sample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sampleapplication.parzival.com.sampleapplication.R
import android.view.LayoutInflater
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class StaggeredAdapter(val context : Context, val list : List<Int>) : RecyclerView.Adapter<StaggeredAdapter.MyViewHolder>() {

    private val TYPE_FULL = 0
    private val TYPE_HALF = 1
    private val TYPE_QUARTER = 2

    override fun getItemViewType(position: Int): Int {
        val modeEight = position % 8
        when (modeEight) {
            0, 5 -> return TYPE_HALF
            1, 2, 4, 6 -> return TYPE_QUARTER
        }
        return TYPE_FULL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false)
        itemView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                val lp = itemView.layoutParams
                if (lp is StaggeredGridLayoutManager.LayoutParams) {
                    val sglp = lp as StaggeredGridLayoutManager.LayoutParams
                    when (viewType) {
                        TYPE_FULL -> sglp.isFullSpan = true
                        TYPE_HALF -> {
                            sglp.isFullSpan = false
                            sglp.width = itemView.width / 2
                        }
                        TYPE_QUARTER -> {
                            sglp.isFullSpan = false
                            sglp.width = itemView.width / 2
                            sglp.height = itemView.height / 2
                        }
                    }
                    itemView.layoutParams = sglp
                    val lm = (parent as RecyclerView).layoutManager as StaggeredGridLayoutManager?
                    lm!!.invalidateSpanAssignments()
                }
                itemView.viewTreeObserver.removeOnPreDrawListener(this)
                return true
            }
        })

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.img_view)
    }

}