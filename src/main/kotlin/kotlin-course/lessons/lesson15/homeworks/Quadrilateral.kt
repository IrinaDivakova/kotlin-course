package org.example.`kotlin-course`.lessons.lesson15.homeworks

class Quadrilateral (
                     color: String,
                     area: Double,
                     angles: Int,
                     sides: Int,
// Новые, специфичные для Треугольника, свойства
                     val length: Double,
                     val width: Double,
                    ) : Polygon(color, area, angles, sides)  {
    fun calculatePerimeter(): Double = 2 * (length + width)
}