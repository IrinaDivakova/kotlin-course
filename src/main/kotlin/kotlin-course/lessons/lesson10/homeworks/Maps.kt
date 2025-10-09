package org.example.`kotlin-course`.lessons.lesson10.homeworks

fun main() {
//    1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val emptyMap = mapOf<String, Int>()
//    2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val map2 = mapOf(125f to 145.2, 78f to 45.12)
    println(map2)
   //    3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val mutableMap = mutableMapOf<Int, String>()
//    4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    val phoneCodes = mutableMapOf<String, String>()
    phoneCodes["+375 "] = " Belarus"
    phoneCodes["+790 "] = " Russia"
    phoneCodes["+87 "] = " China"
    println("Ex.4: $phoneCodes")
//    5. Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
val code = phoneCodes["+375 "]
    println(" +375 is a phone code of $code ")
    if (code !in phoneCodes ) {
        println("Wrong telephone code number")
    }
    val code2 = "+87 "
    val countryName = phoneCodes[code2]
    if (code2 in phoneCodes) {
        println("$code2 is a phone code of $countryName")
    } else {
        println("Wrong telephone code number")
    }
//    6. Удалите определенный элемент из изменяемого словаря по его ключу.
    val phoneCodes6 = mutableMapOf(
    "+375" to "Belarus",
    "+790" to "Russia",
    "+87" to "China",
        "+1" to "USA")
    phoneCodes6.remove("+87")
    println("Ex.6. Map without China $phoneCodes6")
//    7.Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val ex7 = mapOf(1.2 to 4, 402.1 to 3, 78.56 to 0, 78.14 to 9)
//   val result = Double
    for ((k, v) in ex7) {// надо обращаться к паре k, v)
        if (v == 0) {
            println("$k / 0 = бесконечность")
        } else {
           val result = k / v
            println("$k / $v = $result")
        }
    }
//    8.Измените значение для существующего ключа в изменяемом словаре.
    val ex8 = mutableMapOf(
        'a' to 1, 'b' to 2, 'c' to 3, 'd' to 4)
    ex8['c'] = 33
    println(ex8)
//    9.Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
val firstMap = mapOf('a' to 1, 'b' to 2, 'c' to 3)
    val secondtMap = mapOf('d' to 11, 'e' to 12, 'f' to 13)
    val resultMap: MutableMap<Char, Int> = mutableMapOf()
    for (p in firstMap) {
        resultMap += p.toPair() // чтобы можно += сделать, нужно преобразовать ключ и значение в пару
    }
    for (p in secondtMap) {
        resultMap += p.toPair()
    }
    println("ex9 $resultMap")

//    10 Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val ex10: MutableMap<String, List<Int>> = mutableMapOf() // mutableMapOf()  функция конструктор для пустых карт
    ex10["cow"] = listOf(3, 15, 20)
    ex10["cat"] = listOf(3, 1, 18)
    println(ex10)
//   11 Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    val ex11: MutableMap<Int, MutableSet<String>> = mutableMapOf()
    ex11[3] = mutableSetOf("cow", "cat", "dog")
    ex11[5] = mutableSetOf("eagle", "mummy", "daddy")
    ex11[6] = mutableSetOf("kitten", "eraser", "pencil")
    val changedSet = ex11[3]
    if (changedSet != null) { //  у меня было только changedSet.add("map")
        changedSet.add("map")
    }
    println(ex11)

//  12  Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val  ex12: MutableMap<MutableMap<Int, Int>, String > = mutableMapOf()
    ex12[mutableMapOf(1 to 2)] = "one-two"
    ex12[mutableMapOf(2 to 3)] = "two-three"
    ex12[mutableMapOf(3 to 5)] = "three-five"
    ex12[mutableMapOf(4 to 5)] = "four-five"
    ex12[mutableMapOf(5 to 5)] = "five-five"
    for ((k, v) in ex12) {
        for ((a,b) in k) {
            if (a == 5 || b == 5 ) {
                println("in ex12 ${ex12[k]}  responds to the key $k")
            }
        }
    }
////    2. Задачи на подбор оптимального типа для словаря
//   2.1 Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val ex2_1: MutableMap<String, MutableSet<String>> = mutableMapOf()
//    2.2 Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val ex2_2: MutableMap<String, MutableSet<String>> = mutableMapOf()
//   2.3 Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val ex2_3: MutableMap<String, MutableList<String>> = mutableMapOf()
//    Словарь путешественника: Ключи - страны, значения - словари из гор:одов со списком интересных мест.
    val ex2_4: MutableMap<String, MutableMap<String, MutableList<String>>> = mutableMapOf()
}