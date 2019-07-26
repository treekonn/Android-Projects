package by.enolizard.dota2info.features.heroes_list

import by.enolizard.dota2info.App
import by.enolizard.dota2info.api.OpenDotaApi
import by.enolizard.dota2info.entities.Hero
import by.enolizard.dota2info.entities.toEntities
import io.reactivex.Single

class HeroesListRepository {

    private val dao: Hero.Dao = App.db.heroDao()
    private val api: OpenDotaApi = App.api.openDotaApi()

    fun getHeroesByAttr(attr: String): Single<List<Hero.Entity>> {
        return dao.getAllHeroes()
            .flatMap { entities ->
                when {
                    entities.isEmpty() -> api.getFullHeroesList()
                        .map { daos -> daos.toEntities() }
                        .doOnSuccess { dao.insertAllHeroes(it) }
                    else -> Single.just(entities)
                }
            }.map { heroes -> heroes.filter { hero -> hero.attr == attr } }
    }
}
