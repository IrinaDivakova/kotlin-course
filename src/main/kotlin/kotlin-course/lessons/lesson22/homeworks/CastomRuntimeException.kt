package org.example.`kotlin-course`.lessons.lesson22.homeworks

////Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
class CustomRuntimeException
    (message: String,
cause: IndexOutOfBoundsException
) : RuntimeException(message, cause) {
    // Этот класс просто упаковывает Отчет Курьера (cause) в Отчет Менеджера.
}
fun main() {
    val dataList = listOf(10, 20, 30) // Наша полка с данными (3 места)
    val requestedIndex = 5           // Номер полки, который запросил пользователь

    // 1. TRY: "Попробуем найти данные"
    try {
         // вызывает IndexOutOfBoundsException
        val item = dataList[requestedIndex]
        // Курьер пытается взять посылку с полки №5, но полка только до №2!
    }
    // 2. CATCH: "Ловим Отчет Курьера"
    catch (e: IndexOutOfBoundsException) {
        // Менеджер (мы) пишет более понятный Отчет для начальства
        val customMessage = "Ошибка доступа к данным: запрошенный индекс ($requestedIndex) находится за пределами диапазона списка."

        // 3. Обёртывание (Wrapping)
        val wrappedException = CustomRuntimeException(
            message = customMessage, // Наше понятное сообщение
            cause = e                // Оригинальный Отчет Курьера (IndexOutOfBoundsException)
        )
        println(wrappedException)
        // 4. THROW: "Отправляем Отчет начальству"
        throw wrappedException
    }
}