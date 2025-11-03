package org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry

class Triangle (
    val side: Double,
    val h: Double
) : Shape () {
    override fun area(): Double = 0.5 * side * h
}