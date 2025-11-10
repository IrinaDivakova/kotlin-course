package org.example.`kotlin-course`.lessons.lesson18.homeworks
//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
abstract class ProgrammableDevices () : PowerableDevices (), Programmable {
    protected var currentProgram: String? =
        null // protected видно и доступно для чтения/записи всем наследникам, не видно из внешнего кода (main()).

    override fun programAction(action: String) {
        if (isPowered) {
            currentProgram = action
            println("The program $action is set")
        } else {
            println("Error. Turn the device on.")
        }
    }
        override fun execute() {
            if (isPowered && currentProgram != null) {
                println("The device starts: $currentProgram")
            } else if (currentProgram == null) {
                println("Error. Set the $currentProgram")
            } else {
                println("Error. Turn the device on.")
            }
        }
    }
