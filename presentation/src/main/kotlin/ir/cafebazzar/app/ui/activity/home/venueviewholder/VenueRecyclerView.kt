package ir.cafebazzar.app.ui.activity.home.venueviewholder

import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import io.reactivex.subjects.PublishSubject
import ir.cafebazzar.app.domain.entity.VenueModel
import javax.inject.Inject


class VenueRecyclerView @Inject constructor(@NonNull var diffCallback:VenueDiffCallBack,
                        var factory:VenueVHFactory) : ListAdapter<VenueModel, VenueVH>(diffCallback) {

    val mClickPS : PublishSubject<VenueVHAction> = PublishSubject.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueVH {
            return factory.create(parent);
    }

    override fun onBindViewHolder(holder: VenueVH, position: Int) {
        holder.vm.`object` = getItem(position)
        holder.bind()
        holder.itemOnClick(mClickPS)
    }

}