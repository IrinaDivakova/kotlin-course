package org.example.lessons.lesson14.homeworks

class Emotion (
    val type: String,
    val intensity: Int
)
{ fun express () {
    when {
        type == "sadness" && intensity in 1 .. 4-> println("You are a little bit upset")
        type == "sadness" && intensity in 5 .. 6-> println("You are sad")
        type == "sadness" && intensity in 7 .. 8-> println("You are very unhappy")
        type == "sadness" && intensity > 8 -> println("You should see a doctor")
        type == "anger" && intensity in 1 .. 4-> println("You are a little bit angry")
        type == "anger" && intensity in 5 .. 6-> println("You are very angry")
        type == "anger" && intensity in 7 .. 8-> println("You are cross")
        type == "sadness" && intensity > 8 -> println("You are furious")
    }
}
}

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.