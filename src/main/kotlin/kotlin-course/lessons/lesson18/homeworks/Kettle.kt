package org.example.`kotlin-course`.lessons.lesson18.homeworks

class Kettle(
val brand: String,
val capacityLiters: Double
) : PowerableDevices() {
    private val boilingTemp: Int = 100

    fun startBoiling() {
        if (!isPowered) {
            println("🛑 Error: Cannot start boiling. Turn the device on.")
            return
        }
        // Успешный Запуск
        println("🔥 Чайник '$brand' начал нагрев ${capacityLiters}л воды до $boilingTemp°C.")
    }
}