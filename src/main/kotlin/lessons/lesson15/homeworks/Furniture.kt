package org.example.lessons.lesson15.homeworks

open class Furniture (
    val material: String,
    val price: Double
) {
    fun printInfo() {
        println("Material: $material, price: $price")
    }
}

open class Chair(
    material: String,
    price: Double,
    val legs: Int
) : Furniture(material, price)

class OfficeChair(
    material: String,
    price: Double,
    legs: Int,
    val hasWheels: Boolean
) : Chair(material, price, legs)

class Armchair(
    material: String,
    price: Double,
    legs: Int,
    val hasArmrests: Boolean
) : Chair(material, price, legs)

open class Table(
    material: String,
    price: Double,
    val width: Double,
    val height: Double
) : Furniture(material, price)