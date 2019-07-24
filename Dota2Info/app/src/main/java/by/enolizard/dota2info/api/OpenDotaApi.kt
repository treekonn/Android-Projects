package by.enolizard.dota2info.api

import by.enolizard.dota2info.entities.Hero
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

// https://docs.opendota.com/
interface OpenDotaApi {

    @GET("heroes")
    fun getFullHeroesList(): Call<List<Hero.Dto>>

    // FIXME please, remove me
    @GET("heroes")
    fun getFullHeroesListRx(): Single<Response<List<Hero.Dto>>>

}
