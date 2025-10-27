package org.example.`kotlin-course`.lessons.lesson15.homeworks

//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
class InsetrFirstMaterial : Materials() {

    fun insert(item: String) {
        val materials = extractMaterials()
        addMaterial(item)
        materials.forEach {
            addMaterial(it)
        }
    }
}
