package ir.cafebazzar.app.network

import io.reactivex.Single
import ir.cafebazzar.app.network.dto.BaseModel
import ir.cafebazzar.app.network.dto.Venue
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ForSquareApi {

    /**
     * @param ll is your position's lat lang e.g. 44.3,37.2
     * @return nearby's venues list in [Single] format
     */
    //todo remove hard codes.
    @GET("venues/search?client_id=UCPCTHQXHJIHTWHW3FVT5JL5N021PCGJVABJKXGBYWHJYH4P&" +
            "client_secret=PGV3H511WHFGVFNJ102ZIPNNGSA5MAGDM5ISEYNQS1MEQ5JN&v=20190216")
    fun getNearbyVenues(@Query("ll") latLng:String): Single<BaseModel<Venue.VenuesResponse>>

    @GET("venues/{VENUE_ID}?client_id=UCPCTHQXHJIHTWHW3FVT5JL5N021PCGJVABJKXGBYWHJYH4P&" +
            "client_secret=PGV3H511WHFGVFNJ102ZIPNNGSA5MAGDM5ISEYNQS1MEQ5JN&v=20190216")
    fun getVenueDetails(@Path("VENUE_ID") id:String): Single<BaseModel<Venue.VenueResponse>>
}