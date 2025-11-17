package org.example.`kotlin-course`.lessons.lesson20.homeworks
import kotlin.math.absoluteValue
//
//Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел - первое и последнее. Если массив был пуст то вернуть пару из null значений.
fun Array<out Number>.firstAndLast(): Pair<Number?, Number?> {
    return if (this.isEmpty()) {
        Pair(null, null)
    } else {
        Pair(this.first(), this.last())
    }
}
//Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по убыванию, если false (используем функции sort() и sortDescending()
fun <T : Comparable<T>> MutableList<T>.sortAndMakeImmutable(ascending: Boolean): List<T> {
    if (ascending) {
        this.sort() // Сортировка по возрастанию
    } else {
        this.sortDescending() // Сортировка по убыванию
    }
    return this.toList() // Возвращаем неизменяемую копию отсортированного списка
}
//Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null
fun <K, V> Map<K, List<V>?>?.extractIndexedValue(index: Int): Map<String, V?>? {
    // Если исходный словарь null, возвращаем null
    if (this == null) return null

    return this.mapKeys { it.key.toString() } // Преобразование ключей в String
        .mapValues { (_, valueList) ->
            // Проверка, что список значений не null и индекс допустим
            if (valueList != null && index >= 0 && index < valueList.size) {
                valueList[index]
            } else {
                null
            }
        }
}
//Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного не более допустимого значения. Метод принимает два параметра: other — число для сравнения и deviation — максимально допустимое отклонение. Метод должен возвращать true, если разница между текущим числом и числом для сравнения не превышает заданное отклонение. Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.


fun Number.within(other: Number, deviation: Number): Boolean {
    // Приводим оба числа к Double для корректного вычисления разницы
    val currentDouble = this.toDouble()
    val otherDouble = other.toDouble()
    val deviationDouble = deviation.toDouble()

    // Вычисляем абсолютное значение разницы
    val difference = (currentDouble - otherDouble).absoluteValue

    // Проверяем, что разница не превышает отклонения
    return difference <= deviationDouble
}
//Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.

// Метод расширения для шифрования строки: сдвигает каждый символ на 'base' позиций вперёд в Unicode.

fun String.encrypt(base: Int): String {
    return this.map { char ->
        // Прибавляем сдвиг к коду символа
        (char.code + base).toChar()
    }.joinToString("")
}

// Метод расширения для расшифровки строки: сдвигает каждый символ на 'base' позиций назад в Unicode.

fun String.decrypt(base: Int): String {
    return this.map { char ->
        // Вычитаем сдвиг из кода символа
        (char.code - base).toChar()
    }.joinToString("")
}
//Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под ним. Вот ссылка на референс:
//https://x.com/SadNSober_/status/1370280031616897026
fun String.printTwitterGame(users: List<String>) {
    val upperCaseString = this.uppercase()
    val userCount = users.size

    println("--- Twitter Game: ${this} ---")

    // Перебираем строку по символам
    for (i in upperCaseString.indices) {
        val userIndex = i % userCount // Циклическое обращение к списку пользователей
        val author = users[userIndex]
        val letter = upperCaseString[i]

        println("@$author")
        println(letter)
        println("---")
    }
}
fun main() {
    println("==== 1. firstAndLast() Demo ====")
    val numberArray = arrayOf(10, 20.5, 30L, 40)
    val emptyArray = emptyArray<Int>()
    println("Array: ${numberArray.contentToString()} -> ${numberArray.firstAndLast()}")
    println("Array: ${emptyArray.contentToString()} -> ${emptyArray.firstAndLast()}")
    println("--------------------------------")

    println("\n==== 2. sortAndMakeImmutable() Demo ====")
    val mutableList = mutableListOf(5, 1, 4, 2, 3)
    println("Original list: $mutableList")

    val ascendingList = mutableList.sortAndMakeImmutable(true)
    println("Ascending list: $ascendingList (Original list now: $mutableList)")

    val descendingList = mutableList.sortAndMakeImmutable(false)
    println("Descending list: $descendingList (Original list now: $mutableList)")
    println("--------------------------------")

    println("\n==== 3. extractIndexedValue() Demo ====")
    val complexMap = mapOf(
        100 to listOf("A", "B", "C"),
        200 to null,
        300 to listOf("X", "Y")
    )
    val nullableMap: Map<Int, List<String>?>? = null

    println("Index 1: ${complexMap.extractIndexedValue(1)}")
    println("Index 5: ${complexMap.extractIndexedValue(5)}") // Выход за границы -> null
    println("Nullable map: ${nullableMap.extractIndexedValue(0)}")
    println("--------------------------------")

    println("\n==== 4. within() Demo ====")
    val reference = 10.0
    val deviation = 0.5

    println("$reference within 10.4 (dev $deviation): ${reference.within(10.4, deviation)}") // True (Diff 0.4 <= 0.5)
    println("$reference within 10.6 (dev $deviation): ${reference.within(10.6, deviation)}") // False (Diff 0.6 > 0.5)
    println("Int 5 within Long 5L (dev 0): ${5.within(5L, 0)}") // True
    println("--------------------------------")

    println("\n==== 5. encrypt/decrypt() Demo ====")
    val originalString = "Kotlin"
    val shift = 3

    val encrypted = originalString.encrypt(shift)
    val decrypted = encrypted.decrypt(shift)

    println("Original: $originalString")
    println("Encrypted (shift $shift): $encrypted")
    println("Decrypted: $decrypted")
    println("--------------------------------")

    println("\n==== 6. printTwitterGame() Demo ====")
    val tweetString = "Word"
    val usersList = listOf("UserA", "UserB", "UserC")
    tweetString.printTwitterGame(usersList)
    println("--------------------------------")
}