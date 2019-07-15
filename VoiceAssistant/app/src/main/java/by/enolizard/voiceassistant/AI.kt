package by.enolizard.voiceassistant

class AI {
    companion object {
        fun getAnswer(reqQuestion: String): String {
            val database: MutableMap<String, String> = HashMap()
            database.put("hi", "Hi, brother. ")
            database.put("hello", "Hello, human. ")
            database.put("how are you", "Fine, Are you? ")
            database.put("what is you name", "I am a droid! ")

            var userQuestion = reqQuestion.toLowerCase()
            val answers = StringBuffer()

            for (question in database.keys) {
                if (userQuestion.contains(question))
                    database[question]?.let { answers.append(it) }
            }
            Weather.get("Minsk")
            if (answers.isNotEmpty()) {
                return answers.toString()
            }

            return "Ok, understand! "
        }
    }
}
