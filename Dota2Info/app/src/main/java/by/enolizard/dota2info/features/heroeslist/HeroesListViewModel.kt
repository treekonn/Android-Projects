package by.enolizard.dota2info.features.heroeslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.enolizard.dota2info.entities.Hero
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class HeroesListViewModel : ViewModel() {

    private val repository: HeroesListRepository = HeroesListRepository()

    val heroes: MutableLiveData<List<Hero.Dto>> = MutableLiveData()
    private var heroesUpdateChain: Disposable? = null

    fun onClick(attr: String) {
        heroesUpdateChain?.dispose()
        heroesUpdateChain = repository.getAllHeroes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { items ->
                heroes.value = items.filter { it.attribute == attr }
            }
    }
}