package org.example.`kotlin-course`.lessons.lesson15.homeworks

open class SeatingFurniture(
    color: String,
    material: String,
    price: Double,
    val numberOfSeats: Int, // Сколько человек может сидеть
    val hasUpholstery: Boolean // Есть ли обивка/подушки
) : Furniture(color, material, price)