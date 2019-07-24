package by.enolizard.dota2info.api

import by.enolizard.dota2info.entities.Hero
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    private val openDotaApi: OpenDotaApi by lazy { createOpenDotaApi() }

    val fullHeroesListCall: Call<List<Hero.Dto>> get() = openDotaApi.getFullHeroesList()

    // FIXME please, remove me
    val rxHeroesList get() = openDotaApi.getFullHeroesListRx()

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
