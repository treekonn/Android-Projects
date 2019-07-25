package by.enolizard.dota2info

import android.app.Application
import android.content.Context
import androidx.room.Room
import by.enolizard.dota2info.api.ApiService
import by.enolizard.dota2info.db.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDatabaseInstance(context = this)
    }

    companion object {
        val db get() = dbInstance
        val api get() = apiInstance

        private lateinit var dbInstance: AppDatabase
        private var apiInstance: ApiService = ApiService()

        private fun initDatabaseInstance(context: Context) {
            dbInstance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "dota3info.db"
            ).allowMainThreadQueries().build()
        }
    }
}
