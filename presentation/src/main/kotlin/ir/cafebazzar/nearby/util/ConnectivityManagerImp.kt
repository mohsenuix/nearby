package ir.cafebazzar.nearby.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import ir.cafebazzar.nearby.domain.ForApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectivityManagerImp
@Inject constructor(@ForApplication val context: Context) :ir.cafebazzar.nearby.domain.repository.ConnectivityManager{
    override fun hasNetwork(): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}