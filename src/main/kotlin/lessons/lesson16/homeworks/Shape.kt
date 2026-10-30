package org.example.lessons.lesson16.homeworks

import kotlin.math.sin


//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь

open class Shape {
    open fun area() : Double { return 0.0}
}
class Circle(val radius: Double): Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}
class Square (val side: Double): Shape() {
    override fun area(): Double {
        return side * side
    }
}
class Triangle(val sideA: Double, val sideB: Double, val angle: Double): Shape() {
    override fun area(): Double {
        return sideA * sideB * sin(angle* Math.PI / 180)
    }
}

fun main() {
    val list: List<Shape> = listOf(
    Circle(45.2),
        Square(45.1),
        Triangle(12.12, 12.9,12.8),
    Square(7.89) )
    for (it in list) {
       println("the area is ${it.area()}")
        }
    }

