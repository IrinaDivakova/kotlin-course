package org.example.`kotlin-course`.lessons.lesson18.homeworks

import java.io.InputStream

class Oven(
    val brand: String,
    val heatingZones: Int
) : ProgrammableDevices(), TemperatureRegulatable, SoundEmitting {
    private var currentTemperature: Int = 0
    // 2. Обязательная реализация val maxTemperature из интерфейса TemperatureRegulatable
    override val maxTemperature: Int = 250
    // 3. Обязательная реализация fun setTemperature(temp: Int)
    // Копируем логику из TemperatureOpenableDevices, но используем наше поле.
    override fun setTemperature(temp: Int) {
        if (isPowered) {
            if (temp <= maxTemperature) {
                currentTemperature = temp
                println("The set temperature is: $temp")
            } else {
                println("Error! The $temp°C exceeds maximum allowed ($maxTemperature°C).")
            }
        } else {
            println("Temperature can`t be set. Turn on the device.")
        }
    }

    override fun setVolume(volume: Int) { /* ... */ }
    override fun mute() { /* ... */ }
    override fun playSound(stream: InputStream) { /* ... */ }
    override fun programAction(action: String) {
        super.programAction(action)

        if (action.equals("Bake Bread", ignoreCase = true)) {
            setTemperature(180)
            println("🍞 Режим 'Bake Bread' установлен: 180°C.")
        } else {
            println("Программа '$action' установлена.")
        }
    }
    override fun execute() {
        // Проверка базовых ошибок (питание, программа) - делегируем родителю
        if (!isPowered || currentProgram == null) {
            super.execute()
            return
        }

        // Проверка специфики Духовки: должна быть установлена температура выше 0
        if (currentTemperature <= 0) {
            println(" Ошибка: Сначала установите температуру.")
            return
        }

        // Успешный Запуск
        val mode = currentProgram!!
        println(" Духовка '$brand' запущена в режиме '${mode}'.")
        println(" Начался нагрев до $currentTemperature°C.")
    }
}