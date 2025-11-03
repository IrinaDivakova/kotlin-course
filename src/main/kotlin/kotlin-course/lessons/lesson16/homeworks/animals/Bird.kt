package org.example.`kotlin-course`.lessons.lesson16.homeworks.animals

class Bird (
//    val wings: Boolean,
//    var habitat: String,
//    val food: List<String>,
//    val canDo: List<String>,
//    tail: Boolean
): Animal("a bird") {
    override fun makeSound() {
        val colouredSound = Colours.BLUE
        println("This $animalClass tweets: $colouredSound Tweet! Tweet! ${Colours.RESET}")
    }
}
