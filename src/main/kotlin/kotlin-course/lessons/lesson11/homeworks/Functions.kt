package org.example.`kotlin-course`.lessons.lesson11.homeworks

//Задачи на сигнатуру метода
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.

//1.Не принимает аргументов и не возвращает значения.
fun doesNothing() {}

//2. Принимает два целых числа и возвращает их сумму.
fun sum1(a: Int, b: Int): Int {
    return a + b
}

//3.Принимает строку и ничего не возвращает.
fun getString(a: String) {}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun everage(a: List<Int>): Double {
    var sum = 0
    for (i in a) {
        sum += i
    }
    return sum * 1.0 / a.size
}

fun average2(a: List<Int>): Double {
    return a.average()
}

//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun nullString(a: String?): Int? {
    return a?.length // ? - оператор безопасного вызова, означает: "Если объект не null, выполни действие; иначе, просто верни null
}

//6. Не принимает аргументов и возвращает nullable вещественное число.
fun getNothingButReturn(): Double? {
    return null
}

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun getList(a: List<Int>?) {}

//8. Принимает целое число и возвращает nullable строку.
fun returnNullString(a: Int): String? {
    return null
}

//9. Не принимает аргументов и возвращает список nullable строк.
fun getNothingReturn(): List<String>? {
    return null
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun fullNull(a: String?, b: Int?): Boolean? {
    return null
}
//Задачи на написание кода
//Напишите валидную сигнатуру метода а так же рабочий код для задач.

//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(a: Int): Int = a * 2

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(a: Int): Boolean {
    if (a % 2 == 0) {
        return true
    } else {
        return false
    }
}

fun isEven2(a: Int): Boolean = a % 2 == 0

//13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(a: Int) {
    if (a > 1) {
        val resultArray = Array<Int>((a)) { 0 }
        for (i in resultArray.indices) {
            resultArray[i] = i + 1
        }
        println(resultArray.joinToString())
    } else {
        return
    }
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(a: List<Int>): Int? {
    for (i in a) {
        if (i < 0) {
            return i
        }
    }
    return null
}

fun findFirstNegative2(a: List<Int>): Int? {
    return a.find { it < 0 }
}

//15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
//Посетителям
//Правила использования
//Публичная оферта
//Контакт
fun processList(a: List<String?>) {
    for (i in a) {
        if (i == null) {
            return
        }
        println(i)
    }
}

fun main() {
    processList(listOf("Посетителям", "Правила использования", "Публичная оферта", "Контакт"))
}
