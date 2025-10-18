package org.example.`kotlin-course`.lessons.lesson12.homeworks

fun main() {
    val homeCollection = listOf(247, 8, 47, -5, 72, -1, 0, 19)
//    Задачи на приведение коллекции к значению
//           1. Проверить, что размер коллекции больше 5 элементов.
    val isSizeMoreThanFive = homeCollection.size > 5
//   2. Проверить, что коллекция пустая
    val emptyCollection = homeCollection.isEmpty()
//    3. Проверить, что коллекция не пустая
    val notEmptyCollection = homeCollection.isNotEmpty()
//    4. Взять элемент по индексу или создать значение если индекса не существует
    val validIndex = 5
    val invalidIndex = 10
    val index = 6
//    val findElemetWithIndex = homeCollection.getOrElse(validIndex) { "Index not found"}
//    println(findElemetWithIndex)
    println(homeCollection.getOrElse(index) { "Index not found" })
//    5. Собрать коллекцию в строку
    println(homeCollection.joinToString(" * "))
//       6. Посчитать сумму всех значений
    val sum = homeCollection.sum()
//       7. Посчитать среднее
    val average = homeCollection.average()
//      8. Взять максимальное число
    val maxElement = homeCollection.max()
//    9. Взять минимальное число
    val minElement = homeCollection.min()
//    10. Взять первое число или null
    val firstElement = homeCollection.firstOrNull()
//    11. Проверить что коллекция содержит элемент
    val ex11 = 10
    val ifContainsEx11 = homeCollection.contains(ex11)
//Реши задачи подходящим методом для работы с коллекцией. Для каждой задачи есть свой метод, не повторяйся. Список методов в рекомендациях под заданиями.
//
//    Задачи на обработку коллекций
//           12. Отфильтровать коллекцию по диапазону 18-30
    val ex12 = homeCollection.filter { it in 18..30 }
    println(ex12)
//    13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    val ex13 = homeCollection.filterNot { it % 2 == 0 && it % 3 == 0 }
    println(ex13)
//    14. Очистить текстовую коллекцию от null элементов
    val ex14 = homeCollection.filterNotNull()
    println(ex14)
//        15. Преобразовать текстовую коллекцию в коллекцию длин слов
    val stringCollection = listOf("cat", "dog", "rat", "mouse", "bat", "lizard")
    val ex15 = stringCollection.map { it.length }
//    16. Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    val ex16 = stringCollection.associate { it.reversed() to it.length }
    println(ex16)
//    17. Отсортировать список в алфавитном порядке
    val ex17 = println(stringCollection.sorted())
//    18. Взять первые 3 элемента списка
    val ex18 = println(stringCollection.take(3))
//    19. Распечатать квадраты элементов списка
    val ex19 = homeCollection.forEach { print(it * it) }
//   20. Группировать список по первой букве слов
    val ex20 = stringCollection.groupBy { it.first() }
    println(ex20)
//   21. Очистить список от дублей
    val ex21 = homeCollection.distinct()
    println(ex21)
//            22. Отсортировать список по убыванию
    val ex22 = homeCollection.sortedDescending()
    println(ex22)
//            23.Взять последние 3 элемента списка
    val ex23 = stringCollection.takeLast(3)
//    Задача 24. Характеристика числовой коллекции
    println(getListReturnString(listOf(45, 1, -2, 78, 678, -479, 0)))
//    Задача 25. Анализ учебных оценок
//    Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
println("ex.25 ${filterHighMarks(listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12) )}")
//    Задача 26. Создание каталога по первой букве
//    Начальные значения:
val list = listOf( "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка")
    println("ex.26 ${transformListIntoMap(list)}")
//    Задание 27. Подсчёт средней длины слов в списке
//    Начальные значения взять из предыдущей задачи.
//    Задание 28: Категоризация чисел
//    Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(" ex.28 ${listToMapGroupByOddEven(numbers)}")
//    Задание 29: Поиск первого подходящего элемента
//    Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60) и число для проверки возраста, например 18.
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    val ageToFind = 70
    println("ex.29 ${biggerThanAgeToFindOrNull(ages, ageToFind)}")
}

//    Реши задачи ниже в отдельных функциях.
//    Задача 24. Характеристика числовой коллекции
//    Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции используя конструкцию when
fun getListReturnString(a: List<Int>): String {
    return when {
        a.isEmpty() -> "Пусто"
        a.size < 5 -> "Короткая"
        a.first() == 0 -> "Стартовая"
        a.sum() > 10000 -> "Массивная"
        a.average().toInt() == 10 -> "Cбалансированная"
        a.toString().length == 20 -> "Клейкая"
        a.max() < -10 -> "Отрицательная"
        a.min() > 1000 -> "Положительная"
        a.contains(3) && a.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}
//    Задача 25. Анализ учебных оценок
//    Напиши функцию, которая принимает список чисел и возвращает список чисел.
// Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять первые 3. Вызывай методы обработки и фильтрации последовательно один из другого, чтобы результат предыдущего метода являлся основой для следующего.
fun filterHighMarks(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }
        .sorted()
        .take(3)
}
//    Задача 26. Создание каталога по первой букве
//    Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой и значением - строкой.
// Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве используя метод groupBy
//
fun transformListIntoMap(a: List<String>): Map<Char, List<String>> {
    return a
        .map { it.lowercase() }
        .groupBy { it.first() }
}
//    Задание 27. Подсчёт средней длины слов в списке
//    Напиши функцию, которая принимает список строк и возвращает строку.
//Цель: Перевести все слова в количество букв, подсчитать среднее значение. Вернуть форматированный текст с двумя знаками после запятой, используя функцию format и подходящий шаблон.
fun stringToString(a: List<String>): String {
    // 1. Вычисляем длину каждой строки и получаем список длин (Int).
    val wordLengths = a.map { it.length }

    // 2. Вычисляем среднее значение. average() возвращает Double.
    val averageLength = wordLengths.average()

    // 3. Возвращаем форматированный текст с двумя знаками после запятой.

    return String.format( "Средняя длина слова: %.2f символов", averageLength)
//  return a
//           .format(arg.map { it.length.toFloat() }.average())
}
//    Задание 28: Категоризация чисел
//    Напиши функцию, которая принимает список чисел и возвращает словарь с ключами - строками и значениями - числами.
// Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).
fun listToMapGroupByOddEven(a: List<Int>): Map<String, List<Int>> {
    return a.distinct().sortedDescending().groupBy {
        when (it % 2) {
            0 -> "even"
            else -> "odd"
        }
    }
}
//    Задание 29: Поиск первого подходящего элемента
//    Напиши функцию, которая принимает список чисел и число и возвращает nullable число.
//ель: Найти первый возраст в списке, который соответствует условию (больше второго аргумента) и вернуть его, либо null если значения не нашлось.

fun biggerThanAgeToFindOrNull(ages: List<Int?>, ageToFind: Int): Int? {
    return ages
        .filterNotNull()
        .firstOrNull { it > ageToFind} // !! — это приказ компилятору: "Я, программист, клянусь, что эта переменная сейчас не null. Преврати ее в не-nullable тип и дай мне с ней работать. Если я ошибся и там все-таки null, пусть программа упадет."
}