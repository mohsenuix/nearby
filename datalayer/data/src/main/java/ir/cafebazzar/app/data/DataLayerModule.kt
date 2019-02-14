package com.example.datalayer

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * provides dagger dependency injection modules and object life cycle
 * and config all data uses in datalayer module
 */

@Module
class DataLayerModule  {
    private val BASE_API_URL ="https://api.foursquare.com/v2/"

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
        fun provideGson(): Gson = GsonBuilder().setLenient().setLenient().create()


    @Singleton
    @Provides
    fun provideOkHttpClient(@Named("isMock") isMock: Boolean): OkHttpClient {
        val builder = OkHttpClient.Builder()
                //todo change uplaoder and requests
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
        return builder.build()
    }
}
