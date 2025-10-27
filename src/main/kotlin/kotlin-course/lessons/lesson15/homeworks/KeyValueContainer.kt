package org.example.`kotlin-course`.lessons.lesson15.homeworks

class KeyValueContainer : Materials() {
    fun insertKeyValues(data: Map<String, String>) {
        val oldMaterials = extractMaterials() // Очищаем и получаем старые

        val keys = data.keys.toList()
        val values = data.values.toList()

        // 1. Добавляем КЛЮЧИ в начало (используем reversed() для обратного порядка)
        keys.reversed().forEach {
            addMaterial(it)
        }
        // 2. Добавляем СТАРЫЕ МАТЕРИАЛЫ
        oldMaterials.forEach {
            addMaterial(it)
        }
        // 3. Добавляем ЗНАЧЕНИЯ в конец
        values.forEach {
            addMaterial(it)
        }
        println("-> Добавлены ключи (в начале) и значения (в конце).")
    }
}