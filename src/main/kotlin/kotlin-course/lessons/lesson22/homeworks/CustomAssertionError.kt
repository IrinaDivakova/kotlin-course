package org.example.`kotlin-course`.lessons.lesson22.homeworks

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main

class CustomAssertionError  (message: String): AssertionError(message) {
}

fun main() {
      // 1. Условие, которое должно быть нарушено (для триггера ошибки)
    val checkPassed = false

    if (!checkPassed) {
        // Создание экземпляра (объекта) нашего пользовательского исключения,
        // которое передаёт сообщение базовому классу AssertionError.
        val errorMessage = "Не пройден критический тест инициализации системы."
        val myCustomError = CustomAssertionError(errorMessage)

        // Выброс исключения:
       throw myCustomError // ⬅️ Программа немедленно завершится в этой точке.
    }

    // Если бы 'checkPassed' было true, эта строка бы выполнилась.
    println("Проверка завершена успешно.")
}