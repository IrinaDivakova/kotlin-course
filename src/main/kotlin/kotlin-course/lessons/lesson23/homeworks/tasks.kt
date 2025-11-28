package org.example.`kotlin-course`.lessons.lesson23.homeworks

import org.example.`kotlin-course`.kotlin.lesson.e

//1. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка. С помощью require проверь, что список не пустой.
fun task1(a: List<Int>): Double {
    require(a.isNotEmpty())
    val evenNumbers = a.filter { it % 2 == 0 }
    if (evenNumbers.isEmpty()) {
        println("В списке нет чётных чисел. Возвращаем 0.0.")
        return 0.0
    }
    return evenNumbers.average()
}
//Создай аналогичную анонимную функцию.
val t1 = fun (a: List<Int>): Double { // использует ключевое слово fun без имени, но с явным указанием типов параметров и возвращаемого типа
    require(a.isNotEmpty())
    val evenNumbers = a.filter { it % 2 == 0 }
    if (evenNumbers.isEmpty()) {
        println("В списке нет чётных чисел. Возвращаем 0.0.")
        return 0.0
    }
    return evenNumbers.average()
}
//Создай аналогичное лямбда выражение с указанием типа.
val t2: (List<Int>)-> Double = { a ->
    require(a.isNotEmpty())
    val evenNumbers = a.filter { it % 2 == 0 }
    if (evenNumbers.isEmpty()) {
        println("В списке нет чётных чисел. Возвращаем 0.0.")
        0.0
    }
    evenNumbers.average()
}
//Создай лямбда выражение без указания типа.
val t3 = {a: List<Int> ->
    require(a.isNotEmpty())
    val evenNumbers = a.filter { it % 2 == 0 }
    if (evenNumbers.isEmpty()) {
        println("В списке нет чётных чисел. Возвращаем 0.0.")
        0.0
    }
    evenNumbers.average()
    }
//    Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
//2. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
fun task2 (a: Long): Int {
    require(a > 0)
//
//    val numberString = a.toString()
//
//    var sum = 0
//    for (char in numberString) {
//       sum += char.digitToInt()
//    }
    return a.toString().map { it.digitToInt()  }.sum()
}
//Создай аналогичную анонимную функцию.
val t4 = fun (a: Long): Int {
    require(a > 0)

    val numberString = a.toString()

    var sum = 0
    for (char in numberString) {
        sum += char.digitToInt()
    }
    return sum
}
//Создай аналогичное лямбда выражение с указанием типа.
val t5 : (Long) -> Int = { a->
    require(a > 0)
    val numberString = a.toString()
    var sum = 0
    for (char in numberString) {
        sum += char.digitToInt()
    }
     sum
}
//Создай лямбда выражение без указания типа.
val t6 = {a: Long ->
    require(a > 0)
    val numberString = a.toString()
    var sum = 0
    for (char in numberString) {
        sum += char.digitToInt()
    }
    sum
}
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
//3.Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
fun List<Int>.findDuplicates(): Set<Int> {
    return groupBy { it }
        .filter { it.value.size > 1 }
        .keys
        }
//Создай аналогичную анонимную функцию.
val t31 = fun List<Int>.(): Set<Int> {
    return groupBy { it }
        .filter { it.value.size > 1 }
        .keys

}
//Создай аналогичное лямбда выражение с указанием типа.
val t32: List<Int>.() -> Set<Int> = {
     groupBy { it }
        .filter { it.value.size > 1 }
        .keys

}
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
fun main() {

    val testList1 = listOf(1, 2, 3, 4, 5)
    val testList2 = listOf(1, 3, 5)


    val result1 = t3(testList1)
    println("Среднее четных для $testList1: $result1") // Выведет: 3.0

    // Вызов 2
    val result2 = t3(testList2)
    println("Среднее четных для $testList2: $result2") // Выведет: 0.0

    // 3. Проверка пустого списка (требует обработки исключения)
    val emptyList = listOf<Int>()
    try {
        t3(emptyList)
    } catch (e: IllegalArgumentException) {
        println("Успешно: Перехвачено исключение для пустого списка: ${e.message}")

   }
    val data1 = 123456789L
    val result21 = t5(data1)
    println("1. Сумма цифр для $data1: $result21 (Ожидалось: 45)")

    // 2. Число с нулями: 1+0+0+5+0 = 6
    val data2 = 10050L
    val result22 = t5(data2)
    println("2. Сумма цифр для $data2: $result22 (Ожидалось: 6)")

    val data5 = -10L
    try {
        t5(data5)
    } catch (e: IllegalArgumentException) {
        println("5. Успешно перехвачено исключение для $data5: ${e.message}")
    }

    // 6. Ноль (Проверка require)
    val data6 = 0L
    try {
        t5(data6)
    } catch (e: IllegalArgumentException) {
        println("6. Успешно перехвачено исключение для $data6: ${e.message}")
    }

    val data31 = listOf(1, 5, 2, 5, 1, 9, 2)
    println("Список 1: $data1")
    println("Дубликаты: ${data31.t32()}")

    val data32 = listOf(10, 20, 30, 40)
    println("Список 2: $data2")
    println("Дубликаты: ${data32.t32()}")
}
