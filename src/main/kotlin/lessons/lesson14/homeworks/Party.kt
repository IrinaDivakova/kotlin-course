package org.example.lessons.lesson14.homeworks

class Party (
    val location: String,
    val attendees: Int)
{ fun details () {
    println("the party was held at $location and was attended by $attendees people")
}
}

//Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
fun main() {
    val myParty = Party("Beach Club", 50)
    myParty.details()
}