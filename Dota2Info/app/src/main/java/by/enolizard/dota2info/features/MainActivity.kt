package by.enolizard.dota2info.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.enolizard.dota2info.R
import by.enolizard.dota2info.features.heroeslist.HeroesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_main, HeroesListFragment())
            commit()
        }
    }
}
