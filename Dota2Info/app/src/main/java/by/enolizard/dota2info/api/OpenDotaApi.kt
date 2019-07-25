package by.enolizard.dota2info.api

import by.enolizard.dota2info.entities.Hero
import io.reactivex.Single
import retrofit2.http.GET

// https://docs.opendota.com/
interface OpenDotaApi {

    @GET("heroes")
    fun getFullHeroesList(): Single<List<Hero.Dto>>
}
