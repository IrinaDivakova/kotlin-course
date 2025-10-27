package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть свойства “название”, “цена”, “количество”.
data class Product(val name: String, val price: Double, val quantity: Int)

fun main() {
    val mango = Product ("mango", 9.50, 45)
}