package org.example.`kotlin-course`.lessons.lesson22.homeworks

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//
//1, NullPointerException (Исключение нулевого указателя)
val ex1: String? = null
val length = ex1!!.length //'!!' (оператор неnull-утверждения):
//2. IndexOutOfBoundsException (Исключение выхода за границы индекса) отрицательный индекс или индекс, равный или превышающий размер коллекции).
val list2 = listOf(1, 2, 5)
val value = list2[5]
//3. ClassCastException привести объект к типу, который не соответствует его фактическому типу в иерархии наследования.
val str3: String = "abra cadabra"
val number3 = str3 as Int
//4. IllegalArgumentException метод был вызван с незаконным или неподходящим аргументом.
fun ageCounter (date: Int): Int {
   require(date <= 2025) // Проверка аргумента
    return 2025 - date
}
//fun main() {
//    ageCounter(2026) // Вызов с недопустимым аргументом
//}
//5. NumberFormatException использование функций парсинга, таких как .toInt(), .toDouble() или .toLong(), для строк, которые содержат символы, отличные от цифр, или имеют неправильный формат.
val str5 = "147dfg"
val number5 = str5.toInt()
//6. IllegalStateException попытались сделать что-то с объектом в неподходящее время или в неправильном порядке.
class OneTimeRunner {
    private var wasRun = false // Состояние: еще не запущен

    fun run() {
        // Проверка: мы можем запускать, только если 'wasRun' = false
        check(!wasRun) { "Операция 'run' уже была выполнена и является одноразовой." }
        // Изменение состояния
        wasRun = true
        println("Операция выполняется.")
    }
}
//7. OutOfMemoryError
fun makeLargeList() {
    val newList = mutableListOf<Int>()
    while (true) {
        newList.add(1)
    }
}
//8. StackOverflowError
fun endlessRecursion(i: Int) {
    println("Вызов: $i")
    // Нет условия, которое бы остановило рекурсию, i будет расти вечно
    endlessRecursion(i + 1) } //


//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:

//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException преобразовать строку в числовой тип
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент фантастически хорош!
//
fun getAndTransformAny (input: Any?) {
 try {
     val notNullInput = input!! //Оператор Неnull-Утверждения (Bang-Bang). я утверждаю, что это не  null. Если input на самом деле null, выбрасывается NullPointerException.

     val s = notNullInput.toString()
     val char = s[s.length] // индекс равен или превышает длину строки. IndexOutOfBoundsException

     val number = notNullInput as Double

     require(number > 400) {} //Встроенная функция Kotlin для Валидации Аргументов.
 val str = number.toString()
      val integerPart = str.toInt()

//     Используем check() для проверки внутреннего состояния. //IllegalStateException
     check(integerPart != 500) {}

     println("Переданный аргумент фантастически хорош!")
      } catch (e: Throwable) { //Throwable — это корневой (родительский) класс всей иерархии ошибок и исключений
    when (e) {
        is NullPointerException -> println("NullPointerException")
        is IndexOutOfBoundsException -> println("IndexOutOfBoundsException")
        is ClassCastException -> println("ClassCastException")
        is IllegalArgumentException -> println("IllegalArgumentException")
        is NumberFormatException -> println("NumberFormatException")
        is IllegalStateException -> println("IllegalStateException")
        // Ловим все остальные ошибки и исключения
        else -> println("Неизвестный тип исключения")
    }
    // Сразу после when выбрасываем перехваченное исключение, чтобы прекратить работу программы
    throw e
}
}

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main
//
//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
fun main() {
    val runner = OneTimeRunner()

    runner.run()
    runner.run() // IllegalStateException: второй раз запустить нельзя
    endlessRecursion(1)
}