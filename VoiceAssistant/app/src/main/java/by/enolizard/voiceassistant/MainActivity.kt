package by.enolizard.voiceassistant

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val txtArea by lazy { txt_area }
    private val txtQuestion by lazy { txt_question }
    private val btnSend by lazy { btn_send }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {
            val userMsg = txtQuestion.text.toString()
            txtQuestion.setText("")
            txtArea.append("\n>> $userMsg")

            val answer = AI.getAnswer(userMsg)
            txtArea.append("\n<< $answer")
        }
    }
}
