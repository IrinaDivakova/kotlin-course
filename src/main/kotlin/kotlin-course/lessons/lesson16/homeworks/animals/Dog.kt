package org.example.`kotlin-course`.lessons.lesson16.homeworks.animals

class Dog (
//    var habitat: String,
//    val food: List<String>,
//    tail: Boolean
) :Animal("a dog") {
    override fun makeSound() {
        val colouredSound = Colours.PURPLE
        println("This $animalClass barks: $colouredSound Woolf! Woolf! ${Colours.RESET}")
    }
}