package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party (
    var location: String,
    var attendees: Int) {
    fun details() {
        println("The party is held in $location. $attendees people are going to come.")
    }
}