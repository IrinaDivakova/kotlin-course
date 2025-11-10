package org.example.`kotlin-course`.lessons.lesson17.homeworks


fun main () {

    // 1. Объявление и инициализация переменной instance
    val instance = ChildrenClass(
        privateVal = "something private",
        protectedVal = "something protected",
        publicVal = "something public"
    )
    instance.publicField = "Антонио Бандерас"
    instance.setProtectedFieldFromMain("did i do it?")
 println(instance.getAll())
    instance.printText()

//
//    println("--- Проверка результатов ---")
//    println(instance.getAll())
}
