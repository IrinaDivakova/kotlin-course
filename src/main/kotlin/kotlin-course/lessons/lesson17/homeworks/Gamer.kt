package org.example.`kotlin-course`.lessons.lesson17.homeworks

class Gamer (
    val colour: String,//    цвет
    val model: String, //    модель
    private var switchedOn: Boolean, //    включен
    private var loadedOS: String, //    ОС загружена
    val listOfGames: MutableList<String>, //    список установленных игр
    val  navigationСontrol: Boolean,//    наличие джойстика
    private var  incomeBalance:  Double,//    баланс вырученных средств
    val owner: String,//    владелец
    var supportPhoneNumber: String,
//             private set//    телефон поддержки.
    private var gameIsPaid: Boolean,//    игровой сеанс оплачен
    private var oneGameCost: Double,//    стоимость одного игрового сеанса
    private val pinCode: String, //    пин-код автомата
    ) {
    fun switchOn() {}
    fun switchOff() {}
    fun loadOS() {}
    fun stopOS() {}
    fun showListOfGames (listOfGames: MutableList<String>) {}
    fun startGame (gameIsPaid: Boolean) {}//    включить игру
    fun payGame (oneGameCost: Double) {} //    оплатить игровой сеанс
    private fun getMoneyWithPIN (pinCode: String) {} //    забрать наличные с помощью пин-кода
    private fun openTheSafeToGiveCash(): Double {
        val withdraw = incomeBalance
        incomeBalance = 0.0
        return withdraw
    } //    открыть сейф и выдать наличные




//    Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)

//    Поля:

//    Методы:
//
//    включить
//    выключить
//    загрузить ОС
//    завершить работу ОС
//    показать список игр

//    оплатить игровой сеанс


}