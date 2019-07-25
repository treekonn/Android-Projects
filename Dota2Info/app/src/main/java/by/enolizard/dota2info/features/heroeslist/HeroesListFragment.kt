package by.enolizard.dota2info.features.heroeslist

import android.os.Bundle
import android.text.method.SingleLineTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.enolizard.dota2info.R
import by.enolizard.dota2info.api.ApiService
import by.enolizard.dota2info.inflate
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.frag_heroes_list.*

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

        rv_heroes_list.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        val adapter = HeroesListAdapter()
        rv_heroes_list.adapter = adapter
        rv_heroes_list.setHasFixedSize(true)

        Single.fromCallable { ApiService.fullHeroesListCall.execute() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.body()?.let { adapter.setData(it) }
            }, {
                it.printStackTrace()
            })

//        ApiService.rxHeroesList
//            .subscribeOn(Schedulers.io())
//            .subscribe { respo ->
//                respo.body()
//            }


    }
}
