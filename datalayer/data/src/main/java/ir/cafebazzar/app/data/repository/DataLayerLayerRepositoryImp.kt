package ir.cafebazzar.app.data.repository

import io.reactivex.Observable
import io.reactivex.Observable.create
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
    override fun getNearbyVenues(ll: String): Single<List<VenueModel>> {
        return Single.create { emitter ->
                forsquareApi.getNearbyVenues(ll).subscribe {
                    //todo add mapper!
                    venueses->
                    val list = ArrayList<VenueModel>()
                    venueses.forEach { list.add(VenueModel(it.id,it.name,it.contact,it.location.address,
                            LatLng(it.location.lat,it.location.lang),it.verified,it.location.distance,
                            it.categories[0].icon.prefix+it.categories[0].icon.suffix)) }
                    emitter.onSuccess(list)
                }
        }
    }
}