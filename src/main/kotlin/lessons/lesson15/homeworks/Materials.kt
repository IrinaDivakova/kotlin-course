package org.example.lessons.lesson15.homeworks

abstract class Materials {
    private val materials = mutableListOf<String>()

    fun addMaterial(material: String) {
        materials.add(material)
    }

    protected fun addMaterialAt(index: Int, material: String) {
        materials.add(index, material)
    }

    protected fun getMaterials(): MutableList<String> {
        return materials
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class BottomMaterials : Materials() {

    fun addToBottom(material: String) {
        addMaterialAt(0, material)
    }
}

class AlternatingMaterials : Materials() {

    fun addMaterials(materials: List<String>) {
        materials.forEachIndexed { index, material ->
            addMaterialAt(index * 2, material)
        }
    }
}

class SortedMaterials : Materials() {

    fun addSortedMaterial(material: String) {
        addMaterial(material)
        getMaterials().sort()
    }
}

class MapMaterials : Materials() {

    fun addMaterials(materials: Map<String, String>) {

        val keys = materials.keys.toList().reversed()
        val values = materials.values.toList()

        keys.forEachIndexed { index, key ->
            addMaterialAt(index, key)
        }

        values.forEach {
            addMaterial(it)
        }
    }
}