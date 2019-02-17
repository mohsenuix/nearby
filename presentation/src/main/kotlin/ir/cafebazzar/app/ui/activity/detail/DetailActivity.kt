package ir.cafebazzar.app.ui.activity.detail

import android.os.Bundle
import ir.cafebazzar.app.ui.base.BaseDaggerActivity
import ir.cafebazzar.nearby.R
import ir.cafebazzar.app.ui.activity.detail.adapter.DetailSliderAdapter
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : BaseDaggerActivity<DetailActivityViewState,DetailActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createViewModel(DetailActivityViewModel::class.java)
        setContentView(R.layout.activity_detail)
        viewPagerInit()
    }

    override fun handleState(state: DetailActivityViewState) {

    }




    private fun viewPagerInit() {
        val urls = ArrayList<Int>()
        urls.add(R.drawable.r1)
        urls.add(R.drawable.r2)
        urls.add(R.drawable.r3)
        urls.add(R.drawable.r1)
        adapter = DetailSliderAdapter(urls)
        view_pager!!.adapter = adapter
//        indicator!!.setViewPager(viewPager)
    }



//    @BindView(R.id.view_pager)
//    var viewPager: ViewPager? = null
    var adapter: DetailSliderAdapter?=null

//    @BindView(R.id.indicator)
//    var indicator: CircleIndicator? = null

//    @BindView(R.id.detail_appbar)
//    var appBarLayout: AppBarLayout? = null



//
//    @BindView(R.id.img_close)
//    var imgClose: AppCompatImageView? = null

//    @OnClick(R.id.img_close)
//    fun closeClick(view: View) {
//        getContainer().onBackPressed()
//    }








}