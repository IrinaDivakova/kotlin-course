package org.example.`kotlin-course`.lessons.lesson15.homeworks

import kotlin.math.max

//Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
abstract class InsertOneByOne : Materials () {
    fun insertOneByOne(newList: List<String>) {
        val oldMaterials = extractMaterials() // Очищаем и получаем старые

        val maxLen = maxOf(newList.size, oldMaterials.size)

        // Временный список для хранения объединенного порядка
        val combinedList = mutableListOf<String>()

        for (i in 0 until maxLen) {
            // Новый элемент (0, 2, 4...)
            if (i < newList.size) {
                combinedList.add(newList[i])
            }
            // Старый элемент (1, 3, 5...)
            if (i < oldMaterials.size) {
                combinedList.add(oldMaterials[i])
            }
        }

        // Заполняем контейнер обратно
        combinedList.forEach {
            addMaterial(it)
        }
        println("-> Материалы вставлены поочередно.")
    }
}