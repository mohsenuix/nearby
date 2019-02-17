package ir.cafebazzar.nearby.domain.entity


data class VenueModel(val id: String?,
                      val name: String?,
                      val contact: List<String>?,
                      val address: String?,
                      val latLng: LatLng?,
                      val verified: Boolean?,
                      val distance: Int?,
                      val icon: String?)
