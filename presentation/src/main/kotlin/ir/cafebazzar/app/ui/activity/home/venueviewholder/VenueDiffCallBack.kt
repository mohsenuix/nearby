package ir.cafebazzar.app.ui.activity.home.venueviewholder

import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject

class VenueDiffCallBack
@Inject constructor()
    : DiffUtil.ItemCallback<Venue>() {
    override fun areItemsTheSame(oldItem: Venue, newItem: Venue): Boolean =
            oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Venue, newItem: Venue): Boolean {
        return false
    }

}