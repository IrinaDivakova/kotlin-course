package org.example.lessons.lesson18.homeworks
//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammedDevices(
    brand: String,
    serialNumber: String
): PoweredDevice(brand, serialNumber), Programmable
{
    override fun programAction(action: String) {
        println("The $action is set up")
    }
    override fun execute() {
        println("The programm is started")
    }
    open fun finish() {
        println("The program is executed")
    }
}