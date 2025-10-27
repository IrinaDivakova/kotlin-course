package org.example.`kotlin-course`.lessons.lesson15.homeworks

class Sofa(
    color: String,
    material: String,
    price: Double,
    numberOfSeats: Int,
    hasUpholstery: Boolean,
    val length: Double,
    val width: Double,
    val isConvertible: Boolean // Можно ли разложить в спальное место
) : SeatingFurniture(color, material, price, numberOfSeats, hasUpholstery)