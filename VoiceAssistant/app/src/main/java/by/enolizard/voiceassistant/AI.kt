package by.enolizard.voiceassistant

class AI {
    companion object {
        fun getAnswer(question: String): String {
            val database: MutableMap<String, String> = HashMap()
            database.put("привет", "И вам здрасте")
            database.put("как дела", "Да вроде ничего")
            database.put("как тебя зовут", "Я голосовой помощник")
            database.put("кто тебя создал", "Бог не прилогал к этому руку")

            val es = question.toLowerCase()
            val answers = StringBuffer()

            for (ds in database.keys) {
                if (es.contains(ds))
                    database.get(ds)?.let { answers.append(it) }
            }

            if (answers.isNotEmpty()) {
                return answers.toString()
            }

            return "Ok, understand!"
        }
    }
}
