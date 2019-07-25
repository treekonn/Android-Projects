package by.enolizard.dota2info.features.heroeslist

import by.enolizard.dota2info.api.ApiService
import by.enolizard.dota2info.entities.Hero
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HeroesListRepository {

    fun getAllHeroes(): Single<List<Hero.Dto>> {
        return ApiService.rxHeroesList
            .subscribeOn(Schedulers.io())
            .map { res -> res.body()!! }
    }
}