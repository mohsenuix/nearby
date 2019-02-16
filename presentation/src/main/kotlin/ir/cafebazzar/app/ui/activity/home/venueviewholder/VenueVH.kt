package ir.cafebazzar.app.ui.activity.home.venueviewholder

import io.reactivex.subjects.PublishSubject
import android.view.View
import ir.cafebazzar.app.ui.base.recyclerview.BaseViewHolder


class VenueVH(itemView: View, viewModel: VenueViewModel) : BaseViewHolder<VenueVHAction, Venue, VenueViewModel>(itemView, viewModel) {


//    @BindView(R.id.imgAvatarRow)
//    internal var mImgAvatar: SimpleDraweeView? = null
//
//    init {
//        ButterKnife.bind(this, itemView)
//    }

    override fun bind() {

//        mImgAvatar!!.setImageURI(mVM.getAvatarUri())

    }

    override fun itemOnClick(actionSubject: PublishSubject<VenueVHAction>) {
        //        RxView.clicks(itemView)
//                .map({ o -> AvatarVHAction.createSelectAction(adapterPosition) })
//                .repeat()
//                .subscribe(actionSubject)
    }
}