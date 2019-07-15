package by.enolizard.voiceassistant

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val rvDialog by lazy { rv_dialog }
    private val txtQuestion by lazy { txt_question }
    private val btnSend by lazy { btn_send }
    private val msgContoller = MessageController()
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDialog.adapter = msgContoller
        rvDialog.layoutManager = LinearLayoutManager(this)


        btnSend.setOnClickListener {
            val userMsg = txtQuestion.text.toString()
            txtQuestion.setText("")
            msgContoller.addMsg(userMsg, Message.USER)
            val answer = AI.getAnswer(userMsg)
            msgContoller.addMsg(answer, Message.ASSISTANT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts.speak(answer, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

        tts = TextToSpeech(this) {
            tts.language = Locale.ENGLISH
        }
    }
}
