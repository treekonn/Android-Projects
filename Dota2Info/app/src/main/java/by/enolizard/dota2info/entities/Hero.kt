package by.enolizard.dota2info.entities

import com.squareup.moshi.Json

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
        //            get() = "http://api.opendota.com/apps/dota2/images/heroes/" +
        //                    "${codeName.removePrefix("npc_dota_hero_")}_full.png"

    }
}
