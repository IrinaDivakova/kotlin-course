package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
class Concert (val group: String, val venue: String, val cost: Double, val venueCopacity: Int) {
    private var ticketsSold: Int = 0
    fun sellTicket() {
        if (ticketsSold < venueCopacity) {
            ticketsSold += 1
            println(ticketsSold)
        } else {
            println("All ticket are sold")
        }
    }

    fun concertInfo() {
        println("The consert of the band $group is held in $venue. The cost of the ticket is $cost BYN. Tickets left: ${venueCopacity - ticketsSold}")
    }
}

fun main() {
    val myBandConcert = Concert("My band", "Globe", 42.99, 1400)
myBandConcert.sellTicket()
    myBandConcert.concertInfo()

}