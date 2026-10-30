package org.example.lessons.lesson16.homeworks
//Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class Logger () {
    fun  log(message: String) {
        println("INFO $message")
    }
    fun log(level: String, message: String) {
        when (level) {
            "WARNING" -> println("${Colors.YELLOW} $level $message ${Colors.RESET}")
            "ERROR" -> println("${Colors.WHITE} ${Background.RED} $level $message ${Colors.RESET}")
        }
    }
    fun  log(message: List<String>) {
        message.forEach {it -> println("INFO $it")  }
    }
    fun log(exception: Exception) {
        println("ERROR: ${exception.message}")
    }
}
fun main() {
    val logger = Logger()

    // 1. Вызов базового метода (выведет с INFO)
    logger.log("Приложение успешно запущено.")

    // 2. Вызов метода с уровнем и сообщением (с цветами)
    logger.log("WARNING", "Заканчивается свободное место на диске.")
    logger.log("ERROR", "Критический сбой соединения с сервером.")

    // 3. Вызов метода со списком сообщений (все выведутся с INFO)
    val steps = listOf("Инициализация конфига", "Запуск потоков", "Подключение к БД")
    logger.log(steps)

    // 4. Вызов метода с исключением (Exception)
    val databaseException = Exception("Не удалось установить соединение с базой данных.")
    logger.log(databaseException)
}