package ir.cafebazzar.app.data.repository

import io.reactivex.Single
import ir.cafebazzar.app.domain.entity.LatLng
import ir.cafebazzar.app.domain.entity.VenueModel
import ir.cafebazzar.app.domain.repository.DataLayerRepository
import ir.cafebazzar.app.network.ForSquareApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataLayerLayerRepositoryImp
@Inject constructor(private val forsquareApi:ForSquareApi)
    :DataLayerRepository {
    override fun getVenueDetails(id: String): Single<List<VenueModel>> {
        return Single.create { emitter ->
            forsquareApi.getVenueDetails(id).subscribe ({
                //todo add mapper!
                response->
                val list = ArrayList<VenueModel>()
                response.response.venue.also { list.add(VenueModel(it.id,it.name,null,it.location.address,
                        LatLng(it.location.lat,it.location.lang),it.verified,it.location.distance,
                        "")) }
                emitter.onSuccess(list)
            },{
                emitter.onError(it)
            })
        }
    }

    override fun getNearbyVenues(ll: String): Single<List<VenueModel>> {
        return Single.create { emitter ->
                forsquareApi.getNearbyVenues(ll).subscribe ({
                    //todo add mapper!
                    response->
                    val list = ArrayList<VenueModel>()
                    response.response.venues.forEach { list.add(VenueModel(it.id,it.name,null,it.location.address,
                            LatLng(it.location.lat,it.location.lang),it.verified,it.location.distance,
                            "")) }
                    emitter.onSuccess(list)
                },{
                    emitter.onError(it)
                })
        }
    }
}