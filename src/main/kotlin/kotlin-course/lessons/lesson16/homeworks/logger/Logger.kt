package org.example.`kotlin-course`.lessons.lesson16.homeworks.logger

import org.example.`kotlin-course`.kotlin.lesson.e

//Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
class Logger {
    fun log(message: String) {
        println("${Logs.INFO_PREFIX} $message")
    }
    fun log(logType: String, message: String) {
        val colorCode = when (logType) {
            Logs.WARNING_PREFIX -> LogsColours.COLOR_WARNING
            Logs.ERROR_PREFIX -> LogsColours.COLOR_ERROR
            else -> LogsColours.COLOR_DEFAULT
            }
        println("${colorCode}$logType: $message${Colours.RESET}")
        }
    fun log(messages: List<String>) {
        for (message in messages) {
            log(message)
        }
    }
    fun log(exception: Exception) {
       log(Logs.ERROR_PREFIX, "Exception ${exception.message}")
    }
    }
