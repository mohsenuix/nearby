package ir.cafebazzar.app.domain.repository

interface ConnectivityManager {
    fun hasNetwork(): Boolean?
}