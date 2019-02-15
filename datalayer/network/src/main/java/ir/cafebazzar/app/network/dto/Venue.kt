package ir.cafebazzar.app.network.dto

import com.google.gson.annotations.SerializedName

data class Venue(@SerializedName("id") val id:Int,
                 @SerializedName("name") val name:String,
                 @SerializedName("contact") val contact:List<String>,
                 @SerializedName("location") val location:Location,
                 @SerializedName("categories") val categories:List<Category>,
                 @SerializedName("verified") val verified:Boolean,
                 @SerializedName("stats") val stats:Stats)

data class Location(@SerializedName("address") val address:String,
                    @SerializedName("crossStreet") val crossStreet:String,
                    @SerializedName("lat") val lat:Double,
                    @SerializedName("lang") val lang:Double,
                    @SerializedName("distance") val distance:Int)

data class Category(@SerializedName("id") val id:Int,
                    @SerializedName("name") val name:String,
                    @SerializedName("pluralName") val pluralName:String,
                    @SerializedName("shortName") val shortName:String,
                    @SerializedName("icon") val icon:Icon,
                    @SerializedName("primary") val primary:Boolean)

data class Stats(@SerializedName("tipCount") val name:Int,
                 @SerializedName("userCount") val userCount:Int,
                 @SerializedName("checkinsCount") val pluralName:Int)

data class Icon(@SerializedName("prefix") val prefix:String,
                @SerializedName("suffix") val suffix:String)