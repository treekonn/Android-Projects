package by.yakivan.vkfriends.models

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class FriendModel(
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val photo: String = "",
    val online: Boolean = false,
    val city: String = ""
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FriendModel> {
        override fun createFromParcel(parcel: Parcel): FriendModel {
            return FriendModel(parcel)
        }

        override fun newArray(size: Int): Array<FriendModel?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = FriendModel(
            id = json.optInt("id", 0),
            firstName = json.optString("first_name", ""),
            lastName = json.optString("last_name", ""),
            photo = json.optString("photo_200", ""),
            online = (json.optInt("online", 0) == 1)
        )
    }
}