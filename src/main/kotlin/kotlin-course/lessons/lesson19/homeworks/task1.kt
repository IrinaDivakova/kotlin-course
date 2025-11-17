package org.example.`kotlin-course`.lessons.lesson19.homeworks

//Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty()) {
        return null
    }
    val size = list.size
    // Если размер нечетный, есть один средний элемент.
    if (size % 2 != 0) {
        val middleIndex = size / 2
        return list[middleIndex]
    }
    // Если размер четный, среднего элемента нет.
    return null
}
//Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.
fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    // Используем associateBy для создания нового словаря, где значения V становятся ключами, а ключи K — значениями.
    return map.entries.associate { (key, value) -> value to key }
}
fun main() {
    println("--- 1. getMiddleElement Demo ---")
    val oddList = listOf(10, 20, 30)
    val evenList = listOf(1, 2, 3, 4)
    println("Средний элемент в $oddList: ${getMiddleElement(oddList)}") // 30
    println("Средний элемент в $evenList: ${getMiddleElement(evenList)}") // null
    println("--------------------------------")

    println("\n--- 2. ListHolder Demo ---")
    val holder = ListHolder<String>()
    holder.addElement("Apple")
    holder.addElement("Banana")
    println("Элементы: ${holder.getAllElements()}") // [Apple, Banana]
    println("--------------------------------")

    println("\n--- 3/4. Mapper Demo ---")
    val mapper = PhrasesToListOfStrings()
    val singlePhrase = "Hello World Kotlin"
    val listPhrases = listOf("One two three", "Four five")

    println("Строка в список: ${mapper.map(singlePhrase)}")
    println("Список в список списков: ${mapper.mapList(listPhrases)}")
    println("--------------------------------")

    println("\n--- 5. transposition Demo ---")
    val originalMap = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("Оригинал: $originalMap")
    println("Транспонированный: ${transposition(originalMap)}")
    println("--------------------------------")

    println("\n--- 6/7. StringValidator Demo ---")
    val stringValidator = StringValidator()
    println("'text' is valid: ${stringValidator.isValid("text")}") // true
    println("' ' is valid: ${stringValidator.isValid(" ")}") // false
    println("null is valid: ${stringValidator.isValid(null)}") // false
    println("--------------------------------")

    println("\n--- 8. OddValidator Demo (Чётность) ---")
    val oddValidator = OddValidator()
    println("4 is valid (Чётное): ${oddValidator.isValid(4)}") // true
    println("5 is valid (Чётное): ${oddValidator.isValid(5)}") // false
    println("--------------------------------")

    println("\n--- 9. ListValidator Demo ---")
    val listValidatorInt = ListValidator<Int>()
    val listValidatorDouble = ListValidator<Double>()

    // Проверка (Проходит): Все не null, ни один не 0.0
    val validList = listOf(1, 2, 3)
    // Проверка (Не проходит): Содержит null
    val nullElementList = listOf(1, null, 3)
    // Проверка (Не проходит): Содержит 0.0
    val zeroElementList = listOf(1.0, 0.0, 3.0)

    println("Valid list $validList: ${listValidatorInt.isValid(validList)}") // true
    println("Null element list $nullElementList: ${listValidatorInt.isValid(nullElementList)}") // false
    println("Zero element list $zeroElementList: ${listValidatorDouble.isValid(zeroElementList)}") // false

}