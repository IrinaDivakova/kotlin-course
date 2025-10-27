package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
class Emotion (var type: String,var intensity: Int) {
    fun express(type: String, intensity: Int) {
        val description: String =
         when (type.lowercase()) {
            "радость" -> when {
                intensity > 8 -> "Сильная эйфория!"
                intensity > 4 -> "Чувство радости и счастья."
                else -> "Легкое позитивное настроение."
            }
            "гнев" -> when {
                intensity > 8 -> "Неконтролируемая ярость!"
                intensity > 4 -> "Раздражение и злость."
                else -> "Небольшое недовольство."
            }
            "грусть" -> when {
                intensity > 8 -> "Глубокая скорбь и печаль."
                intensity > 4 -> "Легкая меланхолия."
                else -> "Просто немного грустно."
            }
            else -> "Неопределенная эмоция с интенсивностью $intensity."
        }
        println(description)

    }

}