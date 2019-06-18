package by.yakivan.vkfriends.utils

import by.yakivan.vkfriends.models.FriendModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKUsersRequest : VKRequest<List<FriendModel>> {

    constructor(uids: IntArray = intArrayOf()) : super("friends.get") {
//        if (uids.isNotEmpty()) {
//            addParam("user_id", uids.joinToString(","))
//            addParam("user_id", null)
//        }
        addParam("fields", "photo_200, user_id, first_name, last_name, online, city")
        addParam("count", 15)
    }

    override fun parse(r: JSONObject): List<FriendModel> {
        val users = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<FriendModel>()
        for (i in 0 until users.length()) {
            result.add(FriendModel.parse(users.getJSONObject(i)))
        }
        return result
    }
}