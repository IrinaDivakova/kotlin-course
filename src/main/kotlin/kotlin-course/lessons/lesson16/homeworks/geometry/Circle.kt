package org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry

class Circle (
    val radius: Double
) : Shape () {
    override fun area () : Double = 3.14 * radius * radius
}