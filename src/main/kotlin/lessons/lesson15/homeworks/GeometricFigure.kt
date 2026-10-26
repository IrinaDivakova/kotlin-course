package org.example.lessons.lesson15.homeworks

open class GeometricFigure (
val name: String,
val color: String
) {
    fun printInfo() {
        println("Figure: $name, color: $color")
    }
}
open class Polygon(
    name: String,
    color: String,
    val sides: Int,
    val angles: Int
) : GeometricFigure(name, color)

class Triangle(
    color: String,
    val base: Double,
    val height: Double
) : Polygon("Triangle", color, 3, 3)

class Quadrilateral(
    color: String,
    val width: Double,
    val height: Double
) : Polygon("Quadrilateral", color, 4, 4)

class Circle(
    color: String,
    val radius: Double
) : GeometricFigure("Circle", color)