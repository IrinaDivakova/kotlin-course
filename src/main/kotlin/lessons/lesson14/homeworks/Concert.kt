package org.example.lessons.lesson14.homeworks

class Concert(
    var band: String,
    var venue: String,
    var fee: Double,
    var venueCapacity: Int,
    private var soldTickets: Int
) {
    fun concertInfo() {
        println(" The concert of $band is held at $venue. The price of a ticket is $fee")
    }

    fun buyTicket() {
        if (soldTickets < venueCapacity) {
            ++soldTickets
            println("the ticket is sold")
        } else {
            println("Error: All tickets are sold")
        }
    }
}

//Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.