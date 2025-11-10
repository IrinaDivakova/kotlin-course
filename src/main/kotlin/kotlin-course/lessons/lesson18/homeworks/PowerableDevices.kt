package org.example.`kotlin-course`.lessons.lesson18.homeworks
//Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class PowerableDevices: Powerable {
    protected var isPowered: Boolean = false // позволяет наследникам работать с полем, но скрывает его от внешнего кода
    override fun powerOn() {
         if (!isPowered) { // isPowered == false

            isPowered = true // переключаем

           println("The device is ON.")
        } else {
            println("Error. The device is already ON")
        }
    }

    override fun powerOff() {
        if (isPowered) { //(isPowered != false)
            isPowered = false
            println("The device is OFF.")
        } else {
            println("The device is already OFF")
        }

    }
}