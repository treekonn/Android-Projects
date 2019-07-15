package by.enolizard.voiceassistant

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class MessageView : RecyclerView.ViewHolder {
    private val msgText: TextView;
    //    private val msgUsername: TextView;
    private val msgDate: TextView;

    constructor(itemView: View) : super(itemView) {
        msgText = itemView.findViewById(R.id.txt_msg_text)
//        msgUsername = itemView.findViewById(R.id.txt_msg_username)
        msgDate = itemView.findViewById(R.id.txt_msg_date)
    }

    fun bind(msg: Message) {
        msgText.text = msg.text

        val fmt = SimpleDateFormat("HH:mm")
        msgDate.text = fmt.format(msg.date)
    }
}