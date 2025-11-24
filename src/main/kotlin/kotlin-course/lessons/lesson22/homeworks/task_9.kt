package org.example.`kotlin-course`.lessons.lesson22.homeworks

fun main() {

//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок
    val ex9_1: String? = null
    try {
        val length = ex9_1!!.length
        println(length)
    } catch (e: NullPointerException) {
        println("It`s NullPointerException")
    }

    val list2 = listOf(1, 2, 5)
    try {
        val value = list2[5]
    } catch (e: IndexOutOfBoundsException) {
        println("It`s IndexOutOfBoundsException")
    }

    val str3: String = "abra cadabra"
    try {
        val number3 = str3 as Int
    } catch (e: ClassCastException) {
        println("It`s ${e.message}")
    }
    //4. IllegalArgumentException метод был вызван с незаконным или неподходящим аргументом.
//    fun ageCounter (date: Int): Int {
//        require(date <= 2025) // Проверка аргумента
//        return 2025 - date
//    }
    try {
        ageCounter(2026) // Вызов с недопустимым аргументом
    } catch (e: IllegalArgumentException) {
        println("It`s: ${e.message}")
    }
//}
//5. NumberFormatException использование функций парсинга, таких как .toInt(), .toDouble() или .toLong(), для строк, которые содержат символы, отличные от цифр, или имеют неправильный формат.
    val str5 = "147dfg"
    try {
        val number5 = str5.toInt()
        println(number5)
    } catch (e: NumberFormatException) {
        println("It`s ${e.message}")
    }

    //6. IllegalStateException попытались сделать что-то с объектом в неподходящее время или в неправильном порядке.
//    class OneTimeRunner {
//        private var wasRun = false // Состояние: еще не запущен
//        fun run() {
//            // Проверка: мы можем запускать, только если 'wasRun' = false
//            check(!wasRun) { "Операция 'run' уже была выполнена и является одноразовой." }
//            // Изменение состояния
//            wasRun = true
//            println("Операция выполняется.")
//        }
//    }
    val runner = OneTimeRunner()
    runner.run() // Первый вызов успешен, изменяет состояние
    try {
        runner.run() // Второй вызов в нелегальном состоянии
    } catch (e: IllegalStateException) {
        println("It`s ${e.message}")
    }


    //7. OutOfMemoryError
    try {
        makeLargeList()
    } catch (e: OutOfMemoryError) {
        println("It`s ${e.message}")
    }

    //8. StackOverflowError
    fun endlessRecursion(i: Int) {
        println("Вызов: $i")
        // Нет условия, которое бы остановило рекурсию, i будет расти вечно
        endlessRecursion(i + 1)
    } //
    try {
        endlessRecursion(10)
    } catch (e: StackOverflowError) {
        println("It`s ${e.message}")
    }
}


