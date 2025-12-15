package org.example.`kotlin-course`.lessons.lesson27.homeworks

//Задание 1
//Создай Enum со статусами прохождения теста (passed, broken, failed).
enum class Status () {
    PASSED,
    BROKEN,
    FAILED;
}
//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
enum class RealEstate(val definition: String) {
    ROOM ("a room in a flat"),
    STUDIO("a flat studio"),
    APPARTAMENT ("an appartament"),
    ONEROOMFLAT("a flat with 1 bedroom"),
    TWOROMSFLAT("a flat with 2 bedrooms"),
    THREEROOMSFLAT("a flat with 3 bedrooms"),
    FOURROOMSFLAT ("a flat with 4 bedrooms"),
    HOUSE ("a private house");
}
enum class Planet (val distance: Double, val weigh: Double){
    MERCURY(0.4, 0.055),
    VENUS(0.7, 0.815),
    EARTH(1.0, 1.000),
    MARS(1.5, 0.107),
    JUPITER(5.2, 317.8),
    SATURN(9.5, 95.2),
    URANUS(19.2, 14.5),
    NEPTUNE(30.1, 17.1);
}
//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
//
//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.
fun printRealEstate () {
    val listOfRealEstate = RealEstate.values()
    val sortedList = listOfRealEstate.toList().sortedBy { it.name.length }
    println(sortedList)
}
//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения
// и возвращает Enum со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:
fun test(fnc: () -> Unit): Status {
   return try {
       fnc()
       Status.PASSED
   } catch (e: AssertionError) {
       Status.FAILED
   } catch (e: Throwable) {
       Status.BROKEN
   }
}
//если без исключений - PASSED
//если будет AssertionError - FAILED
//прочие исключения  - BROKEN
//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать булево значение.
fun checkPlanet(filter: (Planet) -> Boolean): Planet{
    return Planet.entries
        .firstOrNull(filter)
        ?: throw RuntimeException("Подходящей планеты не найдено")

}
// Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по какому-либо признаку (расстояние или вес).
// Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.
fun main() {
    printRealEstate()
}