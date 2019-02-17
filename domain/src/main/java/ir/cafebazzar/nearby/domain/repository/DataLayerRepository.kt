package ir.cafebazzar.nearby.domain.repository

import io.reactivex.Single
import ir.cafebazzar.nearby.domain.entity.VenueModel

interface DataLayerRepository {
    fun getNearbyVenues(ll:String): Single<List<VenueModel>>
    fun getVenueDetails(id:String): Single<List<VenueModel>>
}