package ir.cafebazzar.app.ui.activity.home.venueviewholder

import ir.cafebazzar.app.ui.base.recyclerview.BaseViewHolderAction




class VenueVHAction(adapterPosition: Int, var state: Int) : BaseViewHolderAction(adapterPosition) {
    companion object {
        var SIMPLE_CLICK_STATE = 10

        fun createSelectAction(adapterPosition: Int): VenueVHAction {
            return VenueVHAction(adapterPosition, SIMPLE_CLICK_STATE)
        }
    }

}