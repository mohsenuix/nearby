package ir.cafebazzar.app.util

import android.location.Location

/**
 * @return distance in Km
 */
fun Location.distance(location: Location): Double {


    val lat_a: Double = latitude
    val lng_a: Double = longitude
    val lat_b: Double = location.latitude
    val lng_b: Double = longitude
    val earthRadius = 3958.75
    val latDiff = Math.toRadians((lat_b - lat_a).toDouble())
    val lngDiff = Math.toRadians((lng_b - lng_a).toDouble())
    val a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) + Math.cos(Math.toRadians(lat_a.toDouble())) * Math.cos(Math.toRadians(lat_b.toDouble())) *
            Math.sin(lngDiff / 2) * Math.sin(lngDiff / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    val distance = earthRadius * c

    val meterConversion = 1609

    return (distance * meterConversion)
}