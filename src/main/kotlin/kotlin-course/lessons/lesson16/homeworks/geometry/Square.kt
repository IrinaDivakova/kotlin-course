package org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry

import org.example.`kotlin-course`.kotlin.lesson.l

class Square (
    val length: Double,
    val width: Double
) : Shape() {
override fun area (): Double = length * width
}
