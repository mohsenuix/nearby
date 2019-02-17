package ir.cafebazzar.app.ui.activity.home.venueviewholder

import io.reactivex.subjects.PublishSubject
import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import ir.cafebazzar.app.domain.entity.VenueModel
import ir.cafebazzar.app.ui.base.recyclerview.BaseViewHolder
import ir.cafebazzar.nearby.R


//todo how to access views here
class VenueVH(itemView: View, viewModel: VenueViewModel) : BaseViewHolder<VenueVHAction, VenueModel, VenueViewModel>(itemView, viewModel) {


//    @BindView(R.id.img_picture)
//    var imgPicture: ImageView? = null
//
//    @BindView(R.id.feed_item)
//    var item: RelativeLayout? = null
//
//    @BindView(R.id.off)
//    var txtOff: TextView? = null
//
//    @BindView(R.id.txt_title)
//    var title: TextView? = null
//
//    @BindView(R.id.txt_subtitle)
//    var subTitle: TextView? = null


    override fun bind() {
//        mImgAvatar!!.setImageURI(mVM.getAvatarUri())
    }

    override fun itemOnClick(actionSubject: PublishSubject<VenueVHAction>) {
                RxView.clicks(itemView.findViewById(R.id.feed_item))
                .map { o -> VenueVHAction.createSelectAction(adapterPosition) }
                        .repeat()
                .subscribe(actionSubject)
    }
}