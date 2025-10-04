package org.example.`kotlin-course`.lessons.lesson9.homeworks

import org.example.`kotlin-course`.kotlin.lesson.m
import org.example.`kotlin-course`.kotlin.lesson.p
import org.example.`kotlin-course`.kotlin.lesson.v

fun main() {


//    1. Работа с массивами Array
//    Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val ar1 = arrayOf(1, 2, 3, 4, 5)
//    Создайте пустой массив строк размером 10 элементов.
    val ar2 = Array<String>(10) { "" }
//    Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val ar3 = Array<Double>(5) { 0.0 }
    for (i in ar3.indices) {
        ar3[i] = i * 2.0
    }
    println(ar3.joinToString())
    val ar3b = DoubleArray(5) { it * 2.0 }
    println(ar3b.joinToString())
//    Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val ar4 = IntArray(5) { 0 }
    for (i in ar4.indices) {
        ar4[i] = i * 3
    }
    println(ar4.joinToString())
//    Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val ar5 = arrayOfNulls<String>(3)
    ar5[0] = null
    ar5[1] = "fhjk"
    ar5[2] = "rtyiyufgk"
    println(ar5.joinToString())
//    Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val ar6 = arrayOf(1, 2, 4, 7, 9)
    val newAr6 = IntArray(ar6.size)
    for (i in newAr6.indices) {
        newAr6[i] = ar6[i]
    }
    println(newAr6.joinToString())
//    Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val ar7One = arrayOf(10, 12, 45, 14, 2)
    val ar7Two = arrayOf(12, 7, 49, 4, 0)
    val ar7Three = IntArray(ar7One.size)
    for (i in ar7Three.indices) {
        ar7Three[i] = ar7One[i] - ar7Two[i]
    }
    println(ar7Three.joinToString())
//    Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.- .
    val ar8 = arrayOf(2, 7, 89, 54, 25, 12)
    var indexOfEl = 0
    var printThis = -1
    while (indexOfEl < ar8.size) {
        if (ar8[indexOfEl] == 5) {
            printThis = indexOfEl
            break
        }
        if (ar8[indexOfEl] != 5) {
            indexOfEl++
        }
    }
    println("ex8. result: $printThis")
    //    val ar8 = arrayOf(2,7,89,54,25,12,5)
//    var indexOfEl= 0
//    var itsFive = ""
//    var noFive = 0
//    while ( indexOfEl <= ar8.size) {
//        if (ar8[indexOfEl] == 5) {
//            itsFive += ""
//        } else {
//            noFive += 1
//            }
//        indexOfEl ++
//            }
//    Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val ar9 = arrayOf(4, 45, 74, 56, 2, 3, 58, 96, 16, 45)
    for (i in ar9.indices) {
        if (ar9[i] % 2 == 0) {
            println("${ar9[i]} is even")
        } else {
            println("${ar9[i]} is odd")
        }
    }
//    10.  Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    ex10(arrayOf("red colour","red rose", "red nose", " pink pig"), "nose")
//   2. Работа со списками List
//   1.Создайте пустой неизменяемый список целых чисел.
    val l1 = listOf<Int>()
//    Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val l2 = listOf<String>("Hello", "World", "Kotlin")
//    Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val l3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
//    Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    l3.addAll(listOf(6, 7, 8))
    println("L3 - $l3")
//    Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val l4: MutableList<String> = mutableListOf("the", "world", "is", "mine", "I", "sing")
    l4.remove("world")
    println("l4: $l4")
//    Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val l5: List<Int> = listOf(4, 8, 9, 14, 58, 79, 125, 124, 36, 9, 5, 78)
    for (i in l5.indices) {
        println("l5 element: ${l5[i]}")
    }
//    Создайте список строк и получите из него второй элемент, используя его индекс.
    val l6: List<String> = listOf("I", "want", "to", "sleep")
    val secondElement = l6.get(1)
    println(secondElement)
//    Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val l7: MutableList<Int> = mutableListOf(47, 79, 52, 3, 1, 0, 78, 95)
    l7[2] = -52
    println(l7)
//    Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val l8First: List<String> = listOf("I", "want", "to", "sleep")
    val l8Second: List<String> = listOf("as", "yesterday", "I", "worked", "a lot")
    val resultList: MutableList<String> = mutableListOf()
    for (i in l8First.indices) {
        resultList.add(l8First[i])
    }
    for (i in l8Second.indices) {
        resultList.add(l8Second[i])
    }
    println("new list: $resultList")
//    Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val l9: List<Int> = listOf(7, 78, -10, 6, 89, 147, -35)
    var minElement: Int = l9[0]
    var maxElement: Int = l9[0]
    for (i in 1 until l9.size) {

        if (minElement > l9[i]) {
            minElement = l9[i]
        }
        if (maxElement < l9[i]) {
            maxElement = l9[i]
        }
    }
    println("min = $minElement")
    println("max = $maxElement")

//    Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val l10: List<Int> = listOf(1, 45, 78, -14, 45, 78, 1, 3, 9, 8)
    val evenList: MutableList<Int> = mutableListOf()
    for (i in l10.indices) {
        if (l10[i] % 2 == 0) {
            evenList.add(l10[i])
        }
    }
    println("only even $evenList")

//    3. Работа с Множествами Set
//   1.Создайте пустое неизменяемое множество целых чисел.
    val s1: Set<Int> = setOf()
//    2.Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val s2: Set<Int> = setOf(1, 2, 3)
//    3.Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val s3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
//    4.Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    s3.addAll(listOf("Swift", "Go"))
    println("new set $s3")
//    5.Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val s5: MutableSet<Int> = mutableSetOf(4, 2, 89, 78, 45, 1, 3)
    s5.remove(2)
    println(s5)
//    6.Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val s6: Set<Int> = setOf(7, 2, 98, 65, 32)
    for (i in s6) {
        println("$i")
    }
//    7.Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    ex7Set(setOf("Kotlin", "Java", "Scala", "Swift", "Go"), "Scala")

//    8.Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val s8: Set<String> = setOf("Kotlin", "Java", "Scala", "Swift", "Go")
    val setIntoList: MutableList<String> = mutableListOf()
    for (i in s8) {
        setIntoList.add(i)
    }
    println("new set: $setIntoList")

}

//  10.  Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun ex10(ar: Array<String>, searchString: String) {
    for (i in ar.indices) {
        if (ar[i].contains(searchString)) {
            println(ar[i])
        }
    }
}

//7.Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun ex7Set(set: Set<String>, searchString: String): Boolean {
    for (element in set) {
        if (element == searchString) {
            return true
        }
    }
    return false
}


