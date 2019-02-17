package ir.cafebazzar.app.domain.repository

import io.reactivex.Single
import ir.cafebazzar.app.domain.entity.VenueModel

interface DataLayerRepository {
    fun getNearbyVenues(ll:String): Single<List<VenueModel>>
    fun getVenueDetails(id:String): Single<List<VenueModel>>
}