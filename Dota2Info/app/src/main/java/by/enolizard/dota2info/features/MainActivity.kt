package by.enolizard.dota2info.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.enolizard.dota2info.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv_hero_attr_types.itemIconTintList = null
    }
}
