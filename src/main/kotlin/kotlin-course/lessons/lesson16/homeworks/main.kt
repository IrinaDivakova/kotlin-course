package org.example.`kotlin-course`.lessons.lesson16.homeworks

import org.example.`kotlin-course`.lessons.lesson16.homeworks.animals.Animal
import org.example.`kotlin-course`.lessons.lesson16.homeworks.animals.Bird
import org.example.`kotlin-course`.lessons.lesson16.homeworks.animals.Cat
import org.example.`kotlin-course`.lessons.lesson16.homeworks.animals.Dog
import org.example.`kotlin-course`.lessons.lesson16.homeworks.basket.Basket
import org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry.Circle
import org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry.Shape
import org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry.Square
import org.example.`kotlin-course`.lessons.lesson16.homeworks.geometry.Triangle
import org.example.`kotlin-course`.lessons.lesson16.homeworks.logger.Logger
import org.example.`kotlin-course`.lessons.lesson16.homeworks.printer.InkjetPrinter
import org.example.`kotlin-course`.lessons.lesson16.homeworks.printer.Printer

fun main () {
    val zoo: List<Animal> = listOf(
        Dog(),
        Cat(),
        Bird()
    )
        for (i in zoo) {
            i.makeSound()

    }
 val listOfFigures: List<Shape> = listOf(
     Circle(10.0),
     Square (15.2, 4.78),
     Triangle(45.2, 12.0)
 )
    for (shape in listOfFigures) {
        println(shape.area())
    }
val message = "I got tired of these strange and difficult tasks"
    val inkjectPrinterMessage: InkjetPrinter = InkjetPrinter()
    inkjectPrinterMessage.printMessage(message)

    val newYearBasket: Basket = Basket(mutableMapOf(1245 to 1))
    newYearBasket.addToCart(listOf(1245, 451, 145))
    println(newYearBasket.toString())

    val logMessage = "Ahtung this class doesnot work"
    val printLog: Logger = Logger()
    printLog.log(logMessage)
    printLog.log("[ERROR]", logMessage)
}