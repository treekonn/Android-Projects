package by.enolizard.dota2info.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.enolizard.dota2info.entities.Hero

@Database(entities = [Hero.Entity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun heroDao(): Hero.Dao
}
