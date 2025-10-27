package org.example.`kotlin-course`.lessons.lesson15.homeworks

open class StorageFurniture(
    color: String,
    material: String,
    price: Double,
    val totalVolumeM3: Double, // Общий объем в кубических метрах
    val isModular: Boolean     // Может ли быть разобрана/собрана
) : Furniture(color, material, price)