package by.enolizard.dota2info.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.enolizard.dota2info.R
import by.enolizard.dota2info.features.heroeslist.HeroesListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv_hero_attr_types.itemIconTintList = null

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_main, HeroesListFragment())
            commit()
        }
    }
}
