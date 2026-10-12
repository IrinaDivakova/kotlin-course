package org.example.lessons.lesson10.homeworks

import org.example.lessons.lesson08.homeworks.logDate

fun main() {


//Задачи на работу со словарём
//1.Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val emptyMap = mapOf<Int, Int> ()
//2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val map2: Map<Float, Double> = mapOf(125.12F to  14.47, 74.14F to 47.145 )
//3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
var mutMap = mutableMapOf<Int, String>()
//4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
mutMap[4] = "2 + 2"
    mutMap[5] = "2 + 3"
    mutMap.putAll(mapOf(6 to "3 + 3", 8 to "4 + 4"))
    println(mutMap)
//5.Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
val keyExist = mutMap[4]
println(keyExist)
    val keyNotExist = mutMap[7]
    println(keyNotExist)
//6. Удалите определенный элемент из изменяемого словаря по его ключу.
mutMap.remove(8)
    println("mutMap without 8 : + $mutMap")
//7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    var  map7 = mapOf(14.2 to  78, 47.14 to  1, 8.45 to  2, 47.01 to 1, 78.78 to 0)
    var result : Double
        for (entry in map7) {
            if (entry.value == 0) {
                println("бесконечность")
            }else{
                result = entry.key / entry.value
                println(result)
            }
    }
//8. Измените значение для существующего ключа в изменяемом словаре.
    mutMap[8] = "7 + 1"
    println(" must be $mutMap instead of 4 + 4")
//9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val map9a = mapOf( "cat" to 3, "dog" to  3, "bird" to 4)
    val map9b = mapOf("кот" to 3, "собака" to 6, "птица" to 5)
    var map9c = mutableMapOf<String, Int>()
    for (entry in map9a) {
        map9c[entry.key] = entry.value
    }
    for (entry in map9b) {
        map9c[entry.key] = entry.value
    }
    println(map9c)
//10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    var map10 = mutableMapOf("dghgj" to listOf(1, 4, 7), "erthb" to listOf(7, 14, 0, -7))
    map10["potatoe"] = listOf(7, 45, 71 ,-759)
    map10["pizza"] = listOf(9, -45, -781)
    println(map10)
//11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    var map11 = mutableMapOf(5 to mutableSetOf("apple", "cherry", "mango"), 6 to mutableSetOf("banana", "charry", "coconut"))
    map11[8] = mutableSetOf("pineapple", "strawberry")
    println("new map $map11")

//    Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    var keyToFind = 5
    var valueToChange = map11[keyToFind]
    if (valueToChange != null) {
        valueToChange.add("metal")
        println("Обновленное множество: $valueToChange")
    } else {
        println("Ключа $keyToFind нет в словаре")
    }
//12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val map12 = mapOf(
        (1 to 1) to "yes",
        (2 to 5) to "yes",
        (3 to 3) to "yes",
        (5 to 4) to "yes")
       for (entry in map12) {
        var key = entry.key
        if(key.first == 5 || key.second == 5) {
            println(entry)
        }
    }
//Задачи на подбор оптимального типа для словаря
//1. Словарь библиотека: Ключи - автор книги, значения - список книг
    var library: MutableMap<String, MutableSet<String>>
//Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    var plants:MutableMap<String, MutableSet<String>>
//Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    var semiFinal: MutableMap<String, List<String>>
//Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    var med: Map<String, List<String>>
//Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
var travel: MutableMap<String, MutableMap<String, MutableSet<String>>>
}