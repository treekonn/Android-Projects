package by.enolizard.dota2info.features.heroeslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.enolizard.dota2info.entities.Hero
import io.reactivex.android.schedulers.AndroidSchedulers

class HeroesListViewModel : ViewModel() {

    private val repository: HeroesListRepository = HeroesListRepository()
    private val heroes: MutableLiveData<List<Hero.Dto>> = MutableLiveData()

    fun getHeroes(): MutableLiveData<List<Hero.Dto>> = heroes

    fun onClick(attr: String) {
        repository.getAllHeroes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { items ->
                heroes.value = items.filter { it.attribute == attr }
            }
    }

}