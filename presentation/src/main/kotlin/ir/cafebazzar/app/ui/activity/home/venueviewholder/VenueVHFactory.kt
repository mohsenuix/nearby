package ir.cafebazzar.app.ui.activity.home.venueviewholder

import android.view.ViewGroup
import ir.cafebazzar.app.ui.base.recyclerview.ViewHolderFactory
import android.view.LayoutInflater
import ir.cafebazzar.nearby.R
import javax.inject.Inject



class VenueVHFactory @Inject
constructor() : ViewHolderFactory<VenueVH> {

    override fun create(parent: ViewGroup): VenueVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_venue, parent, false)
        return VenueVH(view, VenueViewModel())
    }
}