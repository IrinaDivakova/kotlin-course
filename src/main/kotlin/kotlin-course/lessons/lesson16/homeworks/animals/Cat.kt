package org.example.`kotlin-course`.lessons.lesson16.homeworks.animals

class Cat(
//    var habitat: String,
//    val food: List<String>,
//val character: String,
//    tail: Boolean)
): Animal("a cat") {
    override fun makeSound() {
        val colouredSound = Colours.YELLOW
        println("This $animalClass meows: $colouredSound Meow! Meow! ${Colours.RESET}")
    }
}