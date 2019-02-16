package ir.cafebazzar.app.domain.entity


data class VenueModel(val id: Int,
                      val name: String,
                      val contact: List<String>,
                      val address: String,
                      val latLng: LatLng,
                      val verified: Boolean,
                      val distance: Int,
                      val icon: String)
