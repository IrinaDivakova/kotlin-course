package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
object Moon {// Свойства должны быть объявлены внутри тела объекта,
var isVisible: Boolean = true
var phase: String = "Full Moon" // Изначальная фаза

fun showPhase() {
    if (isVisible) {
        val detailedPhase = when (phase.lowercase()) {
            "50% of the moon" -> "Half Moon"
            "100% of the moon" -> "Full Moon"
            "25% of the moon" -> "Quarter Moon"
            else -> phase // Возвращаем исходную строку, если нет совпадения
        }
        // Вывод информации о видимости и фазе
        println("Луна видна. Текущая фаза: $detailedPhase")
    } else {
        // Если isVisible = false, Луна не видна
        println("Луна не видна.")
    }
}
}