package org.example.`kotlin-course`.lessons.lesson15.homeworks

class Triangle(
    color: String,
    area: Double,
    angles: Int,
    sides: Int,
// Новые, специфичные для Треугольника, свойства
    val sideA: Double,
    val sideB: Double,
    val sideC: Double
) : Polygon(color, area, angles, sides) {

    fun calculatePerimeter(): Double = sideA + sideB + sideC
}