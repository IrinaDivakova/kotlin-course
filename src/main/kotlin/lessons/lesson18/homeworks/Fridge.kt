package org.example.lessons.lesson18.homeworks

//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
class Fridge(
    brand: String,
    serialNumber: String,
    noFrost: Boolean = true,
    maxTemperature: Int = 10
) : TemperatureRegulatedAndOpenableDevice
    (brand = brand, serialNumber = serialNumber, maxTemperature = maxTemperature) {
    override fun setTemperature(temp: Int) {
        if (isOn == true) {
            if (temp <= maxTemperature) {
                println("The temperature is set. Current temperature is $temp")
            } else {
                println("Choose temperature lower than $maxTemperature")
            }
        } else {
            println("Switch the device on!")
        }

    }

    fun openAlarm() {
        if (!isOpen) {
            println(" The alarm sound is On")
        }
    }
}

class Kettle(
    brand: String,
    serialNumber: String,
    maxTemperature: Int = 100,
    val currantWaterLevel: Int,
    val minWaterLevel: Int,
    override val capacity: Int
) : TemperatureRegulatedAndOpenableDevice(brand = brand, serialNumber = serialNumber, maxTemperature = maxTemperature), WaterContainer {
    var currentWaterLevel: Int = 0
    var currentTemperature: Int = 20

    override fun setTemperature(temp: Int) {
        if (isOn == true) {
        if (temp <= maxTemperature) {
            println("The temperature is set. Current temperature is $temp")
        } else {
            println("Choose temperature lower than $maxTemperature")
        }
    } else {
        println("Switch the device on!")
    }

}
    override fun fillWater(amount: Int) {
        if (!isOpen) {
            println("Open the kettle first to fill water!")
            return
        }
        if (currentWaterLevel + amount <= capacity) {
            currentWaterLevel += amount
            println("Filled $amount ml. Current water level: $currentWaterLevel ml.")
        } else {
            println("Too much water! Max capacity is $capacity ml.")
        }
    }
    override fun getWater(amount: Int) {
        if (currentWaterLevel >= amount) {
            currentWaterLevel -= amount
            println("Dispensed $amount ml of water. Remaining: $currentWaterLevel ml.")
        } else {
            println("Not enough water in the kettle! Current level: $currentWaterLevel ml.")
        }
    }
    fun boil() {
        if (!isOn) {
            println("Switch the device on!")
            return
        }
        if (currentWaterLevel < minWaterLevel) {
            println("Not enough water! Add some water.")
            return
        }
        println("The kettle $brand starts boiling.")
        currentTemperature = maxTemperature
    }

}
class Oven (
    brand: String,
    serialNumber: String,
    maxTemperature: Int = 250
):TemperatureRegulatedAndOpenableDevice (brand = brand, serialNumber = serialNumber, maxTemperature = maxTemperature), LightEmitting {
    override fun setTemperature(temp: Int) {
        if (!isOn) {
            println("The oven $brand is Off. Switch it on")
        } else {
            if (temp > maxTemperature) {
                println("Error. Temperature mustn`t be more than $maxTemperature")
            } else {
                println("The temperature $temp is set")
            }
        }
    }
    fun playSound(sound: String) {
        println(sound)
    }

    override fun execute() {
        super.execute()
        emitLight()
    }
    override fun finish() {
       super.finish()
       playSound(sound = "horray!")
        completeLightEmission()
    }

    override fun emitLight() {
        println("The light is switched on")
    }

    override fun completeLightEmission() {
        println("The light is switched off")
    }
}

class WashMachine()