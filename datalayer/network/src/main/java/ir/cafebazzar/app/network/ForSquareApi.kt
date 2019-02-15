package ir.cafebazzar.app.network

import io.reactivex.Single
import ir.cafebazzar.app.network.dto.Venue
import retrofit2.http.GET

interface ForSquareApi {

    /**
     * @param ll is your position's lat lang e.g. 44.3,37.2
     * @return nearby's venues list in [Single] format
     */
    @GET("venues/search")
    fun getWeeklyRanking(ll:String): Single<List<Venue>>
}