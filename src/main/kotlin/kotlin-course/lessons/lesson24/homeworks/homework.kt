package org.example.`kotlin-course`.lessons.lesson24.homeworks

//Задачи на синтаксис функций высшего порядка.
//
//Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число
fun ex1 (arg: Boolean, fnc: (String) -> Unit): Int {
    return 5
}
//Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк
fun Int.ex2(fnc: Int.(String) -> List<String>): List<String> {
 val stringToChange = "Something there"
    return this.fnc(stringToChange)
}
//Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик
fun <A,B> A.ex3 (fnc: A.() -> B): B {
    return fnc()
}
//Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку
fun ex4 (a: String): () -> String {
    val fnc: () -> String = { a }
    return fnc
}
//Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик
fun <C> C.ex5 (): (arg: String) -> C {

    val a: (String) -> C = {
       print(it)
        this}
    return a
}
//Задание 6.
//
//Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}
//Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже "в цвете"
// через функцию colorize.
////Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.
//fun String.colorizeWordsmy (fnc: (String) -> String) { //Когда вы вызываете colorizeWords, вы можете передать ей любую функцию, которая соответствует этому контракту, включая ссылку на другую функцию (например, ::applyRedRule), но тип параметра должен быть указан как (String) -> String.
// val words = this.split(" ") // создан список
//     .map {word -> fnc(word)  }.joinToString (" ")
//    println(words)
//}

//Напиши несколько функций обработки слов:
//
//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//начинается с большой буквы
//длина меньше трёх символов
//длина больше 6 символов
//длина кратна двум
////для всех прочих отдельный цвет.
//fun coloringRule1(word: String): String {
//    return when {
//        word.isNotEmpty() && word[0].isUpperCase() -> word.colorize(Colors.RED)
//    word.length < 3 -> word.colorize(Colors.CYAN)
//    word.length > 6 -> word.colorize(Colors.GREEN)
//    word.length % 2 == 0 -> word.colorize(Colors.YELLOW)
//    else -> word.colorize(Colors.BLUE)}
//}
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
// Когда счётчик доходит до края списка слов - он обнуляется и начинается заново.
//val coloringRule2: (String) -> String = {
//    val colors = listOf(Colors.CYAN, Colors.PURPLE, Colors.YELLOW, Colors.GREEN)
//    var counter = 0 // Переменная, которая будет хранить состояние
//    // Возвращаем функцию, которая будет выполнять работу
//    { word ->
//        val color = colors[counter % colors.size]
//        counter++
//
//        word.colorize(color)
//    }
//}


//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик.
// Счётчиком управляет функция, находящаяся в изменяемой переменной. Сначала это функция с инкрементом счётчика.
// Когда счётчик доходит до края списка цветов, нужно заменить функцию счётчика на функцию с декрементом.
// Когда счётчик доходит до нуля - заменить функцию счётчика на функцию с инкрементом и так далее.
//Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай в неё по очереди каждую из функций, проверь результат в консоли.
fun String.colorizeWords(fnc: (String) -> String) {
    val result = split(" ").joinToString(" ") {
        it.colorize(fnc(it))
    }
    println(result)
}

fun main() {
    val colors = listOf(Colors.RED, Colors.BLUE, Colors.GREEN, Colors.PURPLE, Colors.YELLOW, Colors.CYAN)

    val text = "Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом."

//    text.colorizeWordsmy(::coloringRule1)// link to fun

    val ex1 = { word: String ->
        when {
            word[0].uppercase()[0] == word[0] -> Colors.YELLOW
            word.length < 3 -> Colors.BLUE
            word.length > 6 -> Colors.GREEN
            word.length % 2 == 0 -> Colors.RED
            else -> Colors.PURPLE
        }
    }

    var counter = 0

    val ex2 = { _: String ->
        if (counter >= colors.size) counter = 0 // обнуление
        colors[counter++]
    }

    var counterFunction = { counter++ }

    val ex3 = { _: String -> //обязаны принять этот аргумент, чтобы соответствовать контракту функции ((String) -> ...), но нам не нужно использовать его в теле функции.
        if (counter == colors.size - 1) {
            counterFunction = { counter-- }
        }
        if (counter < 0) {
            counter++
            counterFunction = { counter++ }
        }
        colors[counterFunction()]
    }

    text.colorizeWords(ex1)

    text.colorizeWords(ex2)

    counter = 0

    text.colorizeWords(ex3)
}