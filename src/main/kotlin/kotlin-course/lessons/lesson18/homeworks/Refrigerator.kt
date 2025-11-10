package org.example.`kotlin-course`.lessons.lesson18.homeworks
//Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
//
class Refrigerator (val brend: String, val colour: String, private val serialNumber: String) : TemperatureOpenableDevices () {
    override val maxTemperature: Int = 8
    private val minTemperature: Int = -18
    override fun programAction(action: String) {
        super.programAction(action)
        if (action.equals("Super freeze", ignoreCase = true)) {
            currentTemperature = minTemperature
            println("the program \"Super freeze\" is set. t°: $currentTemperature°C.\"")
        } else {
            // Для всех остальных программ устанавливаем стандартную t°
            currentTemperature = 4
            println("Program '$action' is set. t°: $currentTemperature°C.")
        }
    }

    override fun execute() {
        // 1. Проверка Базовых Ошибок (если найдена, то делегируем и выходим)
        if (!isPowered || currentProgram == null) {
            super.execute() // Вывести сообщение об ошибке питания/программы
            return         // Немедленно закончить метод
        }
        // Если код дошел сюда, значит, Базовых Ошибок НЕТ, и можно идти дальше
        val mode = currentProgram!!

        if (mode.equals("Super freeze", ignoreCase = true)) {
            // ⭐️ КОД ЗАПУСКА СУПЕРЗАМОРОЗКИ
            println("СУПЕРЗАМОРОЗКА АКТИВНА! Интенсивное охлаждение до $currentTemperature°C началось.")
        } else {
            // Запуск всех остальных программ
            println(" Холодильник запущен в режиме '${mode}'.")
        }
    }
}
