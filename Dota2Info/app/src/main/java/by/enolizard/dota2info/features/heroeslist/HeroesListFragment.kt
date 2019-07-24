package by.enolizard.dota2info.features.heroeslist

import android.os.Bundle
import android.text.method.SingleLineTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.enolizard.dota2info.R
import by.enolizard.dota2info.api.ApiService
import by.enolizard.dota2info.inflate
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HeroesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.frag_heroes_list)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Single.fromCallable { ApiService.fullHeroesListCall.execute() }
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                response.body()
            }, {
                it.printStackTrace()
            })

        ApiService.rxHeroesList
            .subscribeOn(Schedulers.io())
            .subscribe { respo ->
                respo.body()
            }


    }
}
