package ir.cafebazzar.app.network.dto

import com.google.gson.annotations.SerializedName

sealed class Venue {
    data class Venue(@SerializedName("id") val id: String,
                     @SerializedName("name") val name: String,
                     @SerializedName("contact") val contact: List<String>,
                     @SerializedName("location") val location: Location,
                     @SerializedName("categories") val categories: List<Category>,
                     @SerializedName("verified") val verified: Boolean,
                     @SerializedName("stats") val stats: Stats)

    data class Location(@SerializedName("address") val address: String,
                        @SerializedName("crossStreet") val crossStreet: String,
                        @SerializedName("lat") val lat: Double,
                        @SerializedName("lang") val lang: Double,
                        @SerializedName("distance") val distance: Int)

    data class Category(@SerializedName("id") val id: String,
                        @SerializedName("name") val name: String,
                        @SerializedName("pluralName") val pluralName: String,
                        @SerializedName("shortName") val shortName: String,
                        @SerializedName("icon") val icon: Icon,
                        @SerializedName("primary") val primary: Boolean)

    data class Stats(@SerializedName("tipCount") val name: Int,
                     @SerializedName("userCount") val userCount: Int,
                     @SerializedName("checkinsCount") val pluralName: Int)

    data class Icon(@SerializedName("prefix") val prefix: String,
                    @SerializedName("suffix") val suffix: String)

    data class VenuesResponse(@SerializedName("venues")
                              val venues:List<ir.cafebazzar.app.network.dto.Venue.Venue>)

}