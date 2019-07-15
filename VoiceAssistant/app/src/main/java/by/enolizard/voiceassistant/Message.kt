package by.enolizard.voiceassistant

import java.util.*

class Message(val text: String, val date: Date, val type: Int) {
    companion object {
        val ASSISTANT = 1
        val USER = 2
    }
}
