package by.enolizard.dota2info.features.heroes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import by.enolizard.dota2info.R
import by.enolizard.dota2info.features.hero_profile.HeroProfileFragment
import by.enolizard.dota2info.inflate
import kotlinx.android.synthetic.main.frag_heroes_list.*

class HeroesListFragment : Fragment() {

    private lateinit var viewModel: HeroesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.frag_heroes_list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HeroesListViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bnv_hero_attr_types.itemIconTintList = null
        bnv_hero_attr_types.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_agi_hero_attr -> viewModel.onClick("agi")
                R.id.nav_int_hero_attr -> viewModel.onClick("int")
                R.id.nav_str_hero_attr -> viewModel.onClick("str")
            }
            true
        }
        bnv_hero_attr_types.setOnNavigationItemReselectedListener { }
        viewModel.onClick("str")

        val adapter = HeroesListAdapter(View.OnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container_main, HeroProfileFragment())
                addToBackStack(null)
                commit()
            }
        })

        rv_heroes_list.apply {
            layoutManager = GridLayoutManager(context, 3)
            this.adapter = adapter
            setHasFixedSize(true)
        }

        viewModel.heroes.observe(this, Observer {
            adapter.setData(it)
        })
    }


}
