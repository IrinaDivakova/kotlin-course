package org.example.lessons.lesson18.homeworks


//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class TemperatureRegulatedAndOpenableDevice(
    brand: String,
    serialNumber: String,
    override val maxTemperature: Int
) : ProgrammedDevices(brand, serialNumber), TemperatureRegulatable, Openable {
    var isOpen: Boolean = false// По умолчанию прибор закрыт
    protected set
    override fun open() {
        isOpen = true
        println("Open device $brand serial number $serialNumber")
    }

    override fun close() {
        isOpen = false
        println("Close device $brand serial number $serialNumber")
    }

    override fun setTemperature(temp: Int) {
        if (temp <= maxTemperature) {
            println("The temperature is set. Current temperature is $temp")
        } else {
            println("Choose temperature lower than $maxTemperature")
        }
    }
}