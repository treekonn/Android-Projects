package by.enolizard.dota2info.entities

import androidx.room.*
import com.squareup.moshi.Json
import io.reactivex.Single

interface Hero {
    class Dto(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "localized_name") val name: String,
        @field:Json(name = "name") val codeName: String,
        @field:Json(name = "primary_attr") val attribute: String
    ) {

        val avatarUrl
            get() = "http://cdn.dota2.com/apps/dota2/images/heroes/" +
                    "${codeName.removePrefix("npc_dota_hero_")}_lg.png"
        //  get() = "http://api.opendota.com/apps/dota2/images/heroes/" +
        //  "${codeName.removePrefix("npc_dota_hero_")}_full.png"

        fun toEntity(): Entity {
            return Entity(
                id = this.id,
                name = this.name,
                codeName = this.codeName.removePrefix("npc_dota_hero"),
                attr = this.attribute
            )
        }
    }

    @androidx.room.Dao
    interface Dao {

        @Query("SELECT * FROM all_heroes")
        fun getAllHeroes(): Single<List<Entity>>

        @Insert
        fun insertAllHeroes(list: List<Entity>)
    }

    @androidx.room.Entity(tableName = "all_heroes")
    class Entity(
        @PrimaryKey
        @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "code_name") val codeName: String,
        @ColumnInfo(name = "attr") val attr: String
    ) {
        val avatarUrl get() = "http://cdn.dota2.com/apps/dota2/images/heroes/${codeName}_lg.png"
    }
}

fun List<Hero.Dto>.toEntities(): List<Hero.Entity> {
    val entities: MutableList<Hero.Entity> = ArrayList()

    this.forEach {
        entities.add(it.toEntity())
    }

    return entities
}