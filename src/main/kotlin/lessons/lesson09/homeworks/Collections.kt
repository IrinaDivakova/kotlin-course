package org.example.lessons.lesson09.homeworks

fun main() {


//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    var array1 = arrayOf(1, 2, 3, 4, 5)
    println(array1.toString())
//Создайте пустой массив строк размером 10 элементов.
    var emptyArray = Array(10) { "" }
    println(emptyArray.size)
//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
//val array3 = DoubleArray (5) {
//    for (i in array3.indices) {
//        val i
//        array3[i] = (i * 2).toDouble()
//    }
//}
//println(array3.joinToString())
    val array3 = DoubleArray(5) { it * 2.0 }
    array3.joinToString()
    println(array3)
//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    var array4 = IntArray(5)
    for (i in array4.indices) {
array4[i] = i * 3
    }
//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    var array5 = arrayOf<String?>("ghfl", "hgggggggggkn", null)
    println(array5.toString())
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    var array6: IntArray = intArrayOf(1, 2, 3, 4, 5)
    var newArray6 = IntArray(array6.size)
    for (i in newArray6.indices) {
        newArray6[i] = array6[i]
    }
    println(newArray6.toString())
//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    var array7a: IntArray = intArrayOf(2, 47, 8, 12)
    var array7b: IntArray = intArrayOf(12, 7, 18, 112)
    var array7c: IntArray = intArrayOf()
    for (i in array7c.indices) {
        array7c[i] = array7a[i] - array7b[i]
    }
    println(array7c.toString())
//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    var array8: IntArray = intArrayOf(14,78,-45, 1455, 45, 0)
    var i = 0
    var index = -1

    while (i < array8.size) {
        if (array8[i] == 5) {
            index = i
            break
        }
        i++}
    println(index)
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    var array9: IntArray = intArrayOf(47, 45, 1, 89, -47)
    for (i in array9) {
        if (i % 2 == 0) {
            println("$i - чётное")
        } else {
            println("$i - нечётное")
        }
    }
//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun itContains (a: Array<String>, b: String) {
    for (i in a) {
        if (i.contains(b)) {
            println(i)
        }
    }
}
//Работа со списками List
//Создайте пустой неизменяемый список целых чисел.
    val list1 = listOf(Int)
//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
val list2 = listOf<String>("Hello", "World", "Kotlin")
//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    var list3 = mutableListOf<Int>(1, 2, 3 ,4, 5)
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    list3.addAll(listOf(6, 7, 8))
//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    var list5 = mutableListOf<String> ("Hello", "World", "Kotlin")
    list5.remove("World")
//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    var list6 = listOf<Int>(47, 78, 475, 9, 3, -1245)
    for (number in list6) {
        println(number)
    }
//Создайте список строк и получите из него второй элемент, используя его индекс.
    println(list5.get(1))
//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    var list8 = mutableListOf<Int>(1, 2, 3 ,4, 5)
list8[2]=10
    println(list8)
//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val list9a = listOf<String>("Hello", "World", "Kotlin")
    val list9b = listOf<String>("buy", "five", "islands")
    var list9c = mutableListOf<String>()
    for (i in list9a) {
        list9c.add(i)
    }
    for (i in list9b) {
        list9c.add(i)
    }
    println(list9c)
//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    var list10 = listOf<Int>(47, 78, 475, 9, 3, -1245)
    var min = list10[0]
    var max = list10[0]

    // Перебираем элементы списка
    for (number in list10) {
        if (number < min) {
            min = number
        }
        if (number > max) {
            max = number
        }
    }

    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")

//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
var list11a = listOf<Int>(47, 78, 475, 9, 3, -1245)
var list11b = mutableListOf<Int>()
for (number in list11a) {
    if (number % 2 == 0) {
        list11b.add(number)
    }
}
    println(list11b)
//Работа с Множествами Set
// 1. Создайте пустое неизменяемое множество целых чисел.
    val emptySet = setOf<Int>()

    // 2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val numbersSet = setOf(1, 2, 3)

    // 3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями.
    val languagesSet = mutableSetOf("Kotlin", "Java", "Scala")

    // 4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    languagesSet.add("Swift")
    languagesSet.add("Go")
    // Или сразу  languagesSet.addAll(listOf("Swift", "Go"))

    // 5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val numbersMutable = mutableSetOf(1, 2, 3, 4, 5)
    numbersMutable.remove(2)

    // 6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val setForLoop = setOf(10, 20, 30, 40)
    for (number in setForLoop) {
        println(number)
    }

    // 8. Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val immutableSet = setOf("apple", "banana", "cherry")
    val mutableList = mutableListOf<String>()

    for (item in immutableSet) {
        mutableList.add(item)
    }

    println(mutableList) // Выведет: [apple, banana, cherry]
}

// 7. Функция, которая принимает множество строк и строку, проверяет наличие через цикл и печатает true/false
fun checkContains(set: Set<String>, target: String) {
    var found = false

    for (item in set) {
        if (item == target) {
            found = true
            break // Элемент найден, выходим из цикла
        }
    }

    println(found)
}
