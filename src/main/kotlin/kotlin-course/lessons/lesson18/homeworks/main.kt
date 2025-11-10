package org.example.`kotlin-course`.lessons.lesson18.homeworks

fun main() {
    val fridge = Refrigerator("LG", "Steel", "SN123")
    println("\n--- 1. ТЕСТ ХОЛОДИЛЬНИКА ---")

    // ❌ Тест 1: Запуск без питания (проверка логики родителя)
    fridge.execute()

    fridge.powerOn()

    // ❌ Тест 2: Запуск с открытой дверцей (проверка специфики Refrigerator)
    fridge.open()
    fridge.programAction("Normal")
    fridge.execute()

    // ✅ Тест 3: Успешный запуск Суперзаморозки
    fridge.close()
    fridge.programAction("Super freeze")
    fridge.execute()

    // =================================================================
    // 2. СТИРАЛЬНАЯ МАШИНА (WashingMachine)
    // =================================================================

    val washer = WashingMashines("Bosch", "8000")
    println("\n--- 2. ТЕСТ СТИРАЛЬНОЙ МАШИНЫ ---")
    washer.powerOn()

    // ✅ Тест 4: Установка и запуск программы 'Quick Wash'
    washer.programAction("Quick Wash") // Установит 40°C и 30 минут
    washer.close()
    washer.execute()

    // Тест методов SoundEmitting
    washer.setVolume(5)
    washer.mute()

    val kettle = Kettle("Tefal", 1.7)
    println("\n--- 3. ТЕСТ ЧАЙНИКА ---")

    // Тест 5: Запуск без питания
    kettle.startBoiling()
    kettle.powerOn()
}