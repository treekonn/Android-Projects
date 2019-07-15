package by.enolizard.voiceassistant

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MessageController : RecyclerView.Adapter<MessageView>() {
    private val msgList: MutableList<Message> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageView {
        return when (viewType) {
            Message.USER -> MessageView(parent.inflate(R.layout.user_message))
            else -> MessageView(parent.inflate(R.layout.assistant_message))
        }
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: MessageView, position: Int) {
        holder.bind(msgList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type
    }

    fun addMsg(text: String, type: Int) {
        msgList.add(Message(text, Date(), type))
        notifyDataSetChanged()
    }
}
