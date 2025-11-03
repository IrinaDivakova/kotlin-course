package org.example.`kotlin-course`.lessons.lesson16.homeworks.animals


// Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
open class Animal (
 val animalClass: String
//    , val legs: Int, val tail: Boolean
) {
   open fun makeSound() {
       println("This $animalClass makes no sound.")
   }
}
