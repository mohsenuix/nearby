package ir.cafebazzar.nearby.ui.activity.home.venueviewholder

import androidx.recyclerview.widget.DiffUtil
import ir.cafebazzar.nearby.domain.entity.VenueModel
import javax.inject.Inject

class VenueDiffCallBack
@Inject constructor()
    : DiffUtil.ItemCallback<VenueModel>() {
    override fun areItemsTheSame(oldItem: VenueModel, newItem: VenueModel): Boolean =
            oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VenueModel, newItem: VenueModel): Boolean {
        return false
    }

}