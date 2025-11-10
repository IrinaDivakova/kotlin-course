package org.example.`kotlin-course`.lessons.lesson18.homeworks

import java.io.InputStream

class WashingMashines(
    val brand: String,
    val model: String
) : TemperatureOpenableDevices(), SoundEmitting, Timable {
    // Максимальная температура стирки
    override val maxTemperature: Int = 95

    private var timerDuration: Int = 0

     // Реализация SoundEmitting
    override fun setVolume(volume: Int) {
        println("Volume set to: $volume")
    }
    override fun mute() {
        println("Washing machine sounds are muted.")
    }

    // InputStream здесь просто заглушка для демонстрации контракта
    override fun playSound(stream: InputStream) {
        println(" Playing custom sound/alert from input stream.")
    }
    // Реализация Timable
    override fun setTimer(duration: Int) {
        timerDuration = duration
        println("Washing cycle duration set to $duration minutes.")
    }
    override fun execute() {
        // ПРЯМАЯ ПРОВЕРКА Базовых Ошибок
        if (!isPowered) {
            println(" Error: Turn the device on.")
            return
        }
        if (currentProgram == null) {
            println("Error: Установите программу стирки.")
            return
        }

        // Проверка Специфики: Дверца
        if (isOpened) {
            println("Ошибка: Запуск невозможен! Дверца должна быть закрыта.")
            return
        }

        // Успешный Запуск
        val mode = currentProgram!!
        println("Стиральная машина '$brand' запущена в режиме '${mode}'.")
        println("🌡️ Начался нагрев воды до $currentTemperature°C.")
        if (timerDuration > 0) {
            println("⌛️ Общее время цикла: $timerDuration минут.")
        }
    }

    // Переопределение programAction для установки специальных режимов (например, 'Quick Wash')
    override fun programAction(action: String) {
        super.programAction(action)

        if (action.equals("Quick Wash", ignoreCase = true)) {
            currentTemperature = 40
            setTimer(30)
            println(" Режим 'Quick Wash' установлен: 40°C, 30 минут.")
        }

    }
}