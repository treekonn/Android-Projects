package by.enolizard.dota2info.entities

import com.squareup.moshi.Json

interface Hero {
    class Dto(
        @field:Json(name = "id") val id: Int,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "localized_name") val localizedName: String,
        @field:Json(name = "primary_attr") val attribute: String
    )
}