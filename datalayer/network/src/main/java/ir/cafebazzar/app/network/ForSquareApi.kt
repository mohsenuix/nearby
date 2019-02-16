package ir.cafebazzar.app.network

import io.reactivex.Single
import ir.cafebazzar.app.network.dto.Venue
import retrofit2.http.GET
import retrofit2.http.Query

interface ForSquareApi {

    /**
     * @param ll is your position's lat lang e.g. 44.3,37.2
     * @return nearby's venues list in [Single] format
     */
    @GET("venues/search?client_id=UCPCTHQXHJIHTWHW3FVT5JL5N021PCGJVABJKXGBYWHJYH4P&&" +
            "client_secret=PGV3H511WHFGVFNJ102ZIPNNGSA5MAGDM5ISEYNQS1MEQ5JN")
    fun getNearbyVenues(@Query("ll") latLng:String): Single<List<Venue>>
}