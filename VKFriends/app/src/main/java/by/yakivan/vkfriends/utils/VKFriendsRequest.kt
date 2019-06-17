package by.yakivan.vkfriends.utils

import by.yakivan.vkfriends.models.FriendModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKUsersRequest : VKRequest<List<FriendModel>> {

    constructor(uids: IntArray = intArrayOf()) : super("users.get") {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString(","))
        }
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): List<FriendModel> {
        val users = r.getJSONArray("response")
        val result = ArrayList<FriendModel>()
        for (i in 0 until users.length()) {
            result.add(FriendModel.parse(users.getJSONObject(i)))
        }
        return result
    }
}