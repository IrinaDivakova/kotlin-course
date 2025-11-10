package org.example.`kotlin-course`.lessons.lesson18.homeworks
//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class TemperatureOpenableDevices (): ProgrammableDevices (), TemperatureRegulatable, Openable {
    protected var isOpened: Boolean = false
    protected var currentTemperature: Int = 17
    abstract override val maxTemperature: Int
    override fun open() {
        if (isPowered) {
            if (!isOpened) {
                isOpened = true
                println("The device is opened")
            } else {
                println("The device is already opened")
            }
        } else {
            println("Error. Turn on the device.")
        }
    }

    override fun close() {
        if (isPowered) {
            if (isOpened) {
                isOpened = false
                println("The device is closed")
            } else {
                println("The device is already closed")
            }
        } else {
                println("Error. Turn on the device.")
            }
        }

    override fun setTemperature(temp: Int) {
        if (isPowered) {
            if (temp <= maxTemperature) {
                currentTemperature = temp
                println("The set temperature is: $temp")// параметр метода вставляем
            } else {
                println("Error! The $temp°C exceeds maximum allowed ($maxTemperature°C).")
            }
        } else {
            println("Temperature can`t be set. Turn on the device.")
        }
    }
}