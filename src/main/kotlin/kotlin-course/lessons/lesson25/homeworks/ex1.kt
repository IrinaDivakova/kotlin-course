package org.example.`kotlin-course`.lessons.lesson25.homeworks

//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
fun timeTracker (fnc: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    fnc()
    val endTime = System.currentTimeMillis()
    return endTime-startTime

}
// Функция timeTracker должна возвращать затраченное время в миллисекундах.
// Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.
//
//Для проверки результата можно выполнить в ней например такой ресурсоёмкий код:
fun main() {
    val myFunction = {
        val list = List(50000000) { (0..80000).random() }
        list.sorted()
    }
    val ex1 = timeTracker { myFunction }
    println(ex1)
}
