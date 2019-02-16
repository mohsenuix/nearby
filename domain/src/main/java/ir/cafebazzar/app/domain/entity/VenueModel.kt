package ir.cafebazzar.app.domain.entity


data class VenueModel(val id: Int,
                      val name: String,
                      val contact: List<String>,
                      val address: String,
                      val lat: Double,
                      val lng: Double,
                      val verified: Boolean,
                      val distance: Int,
                      val icon: String)
