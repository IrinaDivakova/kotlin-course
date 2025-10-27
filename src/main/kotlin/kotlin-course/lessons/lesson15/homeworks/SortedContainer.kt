package org.example.`kotlin-course`.lessons.lesson15.homeworks

class SortedContainer : Materials() {
    fun insertSorted(item: String) {
        val allMaterials = extractMaterials().toMutableList() // Очищаем и получаем старые

        allMaterials.add(item)  // Добавляем новый элемент во временный список
        allMaterials.sort()     // Сортируем временный список

        // Заполняем контейнер обратно уже отсортированными
        allMaterials.forEach {
            addMaterial(it)
        }
        println("-> Добавлен '$item' и список отсортирован.")
    }
}