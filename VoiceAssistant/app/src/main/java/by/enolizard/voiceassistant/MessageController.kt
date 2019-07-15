package by.enolizard.voiceassistant

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MessageController : RecyclerView.Adapter<MessageView>() {
    private val msgList: MutableList<Message> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageView {
        return MessageView(parent.inflate(R.layout.assistant_message))
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: MessageView, position: Int) {
        holder.bind(msgList[position])
    }

    fun addMsg(text: String) {
        msgList.add(Message(text, Date(),false))
notifyDataSetChanged()
    }
}
