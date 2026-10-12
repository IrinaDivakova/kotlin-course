package org.example.lessons.lesson11.homeworks

//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.
//
//Не принимает аргументов и не возвращает значения.
fun ex1() {}
//Принимает два целых числа и возвращает их сумму.
fun ex2 (a: Int, b: Int): Int = a + b
//Принимает строку и ничего не возвращает.
fun ex3 (a: String) {}
//Принимает список целых чисел и возвращает среднее значение типа Double.
fun ex4 (a: List<Int>): Double = a.average()
//Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun ex5 (a: String?): Int? = a?.length
//Не принимает аргументов и возвращает nullable вещественное число.
fun ex6(): Int? = null
//Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun ex7(a: List<Int>?) {}
//Принимает целое число и возвращает nullable строку.
fun ex8 (a: Int) : String? = null
//Не принимает аргументов и возвращает список nullable строк.
fun ex9 (): List<String>? {
    return null
}
//Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun ex10 (a: String?, b: Int?): Boolean? {
    return null
}

//Напишите валидную сигнатуру метода а так же рабочий код для задач.
//
//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo (a: Int) : Int = a * 2
//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven (a: Int) : Boolean {
    if (a % 2 == 0) {
        return true
    }else{
        return false
    }
}
fun isEven2 (a: Int) : Boolean = a % 2 == 0
//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil (a: Int) {
    if (a > 1) {
        return
    }
    for (result in 1..a) {
        println(result)
    }
}

//Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative (a: List<Int>): Int? {
    for (i in a) {
        if (i < 0) {
            return i
             }
    }
    return null
    }
fun findFirstNegative2 (a: List<Int>): Int? {
    return a.firstOrNull { it < 0}
}
//Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(a: List<String?>) {
    for (item in a) {
        if (item == null) {
            return // Прекращаем выполнение функции, если встретили null
        }
        println(item)
    }
}
