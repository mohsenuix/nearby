package ir.cafebazzar.nearby.domain.repository

interface ConnectivityManager {
    fun hasNetwork(): Boolean?
}