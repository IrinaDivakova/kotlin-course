package org.example.lessons.lesson16.homeworks

import org.example.lessons.lesson04.homework.b
import java.awt.Color

//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
open class Animal (
    val legs: Int,
    val wings: Int? = 0
){ open fun makeSound(color: String, background: String = ""){
    println("$color $background This animal makes no sound.")
}

}
class Dog (val height: Int, val breed: String): Animal (4, 0) {
    override fun makeSound(color: String, background: String) {
        println("$color$background Bark${Colors.RESET}")
    }
}
class Cat (val age: Int, val breed: String): Animal(4,0) {
    override fun makeSound(color: String, background: String) {
        println("$color$background Meow${Colors.RESET}")
    }
}
class Bird (val canSwim: Boolean, val canFly: Boolean = true, val name: String): Animal(2,2) {
    override fun makeSound(color: String, background: String) {
        println("$color$background Tweet${Colors.RESET}")
    }

}

fun main() {
    val list = listOf(
        Dog(50, "двортерьер"),
        Cat(12, "британка"),
        Dog(20, "пикенес"),
        Bird(false,true, "синица")
    )
    for (animal in list) {
        when (animal) {
            is Dog -> animal.makeSound(Colors.BLACK, Background.CYAN)
            is Cat -> animal.makeSound(Colors.RED, Background.GREEN)
            is Bird -> animal.makeSound(Colors.PURPLE, Background.YELLOW)
        }

    }
}