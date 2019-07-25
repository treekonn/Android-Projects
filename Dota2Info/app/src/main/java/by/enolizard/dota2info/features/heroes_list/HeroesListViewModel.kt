package by.enolizard.dota2info.features.heroes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.enolizard.dota2info.entities.Hero
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HeroesListViewModel : ViewModel() {

    private val repository: HeroesListRepository = HeroesListRepository()

    val heroes: MutableLiveData<List<Hero.Dto>> = MutableLiveData()
    private var heroesUpdateChain: Disposable? = null

    fun onClick(attr: String) {
        heroesUpdateChain?.dispose()
        heroesUpdateChain = repository.getHeroesByAttr(attr = attr)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(heroes::setValue)
    }
}
