package org.example.lessons.lesson18.homeworks

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class PoweredDevice(
    val brand: String,
    val serialNumber: String,

)  : Powerable {
    var isOn: Boolean = false
        protected set
    override fun powerOn() {
        isOn = true
            println("The device $brand $serialNumber is ON")
        }

    override fun powerOff() {
           isOn = false
            println("The device $brand $serialNumber is OFF")
        }

}