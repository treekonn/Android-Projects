package by.enolizard.dota2info.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {

    fun openDotaApi() = openDotaApi

    private val openDotaApi: OpenDotaApi by lazy { createOpenDotaApi() }

    private fun createOpenDotaApi(): OpenDotaApi {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        return retrofit.create(OpenDotaApi::class.java)
    }
}
