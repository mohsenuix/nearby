package ir.cafebazzar.app.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import ir.cafebazzar.app.network.ForSquareApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * provides dagger dependency injection modules and object life cycles
 * and configs all data uses in datalayer module
 */

@Module
class DataLayerModule  {
    //todo The base url should received from server.
    private val BASE_API_URL ="https://api.foursquare.com/v2/"

    @Singleton
    @Provides
    fun provideForSquareApi(retrofit: Retrofit): ForSquareApi =
            retrofit.create(ForSquareApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
            Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build()

    @Singleton
    @Provides
        fun provideGson(): Gson = GsonBuilder().setLenient().create()


    @Singleton
    @Provides
    fun provideOkHttpClient(@Named("isMock") isMock: Boolean): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
        return builder.build()
    }
}
