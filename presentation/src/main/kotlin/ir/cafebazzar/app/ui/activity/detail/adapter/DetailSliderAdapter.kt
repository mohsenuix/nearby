package ir.cafebazzar.app.ui.activity.detail.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide

import androidx.viewpager.widget.PagerAdapter
import ir.cafebazzar.nearby.R


class DetailSliderAdapter(//todo fake
        internal var urls: List<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return urls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context.applicationContext)
                .inflate(R.layout.view_pager_detail, container, false)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        Glide.with(container.context.applicationContext).load(urls[position]).into(imageView)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}
