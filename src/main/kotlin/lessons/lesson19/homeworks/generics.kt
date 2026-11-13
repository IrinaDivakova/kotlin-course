package org.example.lessons.lesson19.homeworks

//Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.
//
//1.  Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
fun <T> getMiddleElement (list: List<T>): T? {
    return if (list.size % 2 == 0 ) {
        null
    }else{
        list[list.size / 2 +1]
    }
}
//2. Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.
abstract class ListHolder <T> (val mutableList: MutableList<T>) {
    fun addAndReturn (element: T): List<T> {
        mutableList.add(element)
        return mutableList.toList()
    }
}

//3. Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа
interface Mapper <T, R> {
    fun mapElementTransform (item: T) : R
    fun mapListTransform (list: List<T>): List<R>
}
//4. Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>. Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков с аналогичной механикой.
 class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun mapElementTransform(item: String): List<String> {
        return  item.trim().split(" ")
    }

    override fun mapListTransform(list: List<String>): List<List<String>> {
        return list.map { mapElementTransform(it) }
    }
 }
//5.Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.
fun <T, R> transposition (map: Map<T, R>) : Map<R, T> {
    return map.entries.associate { (key, value) -> value to key } // associate проходит по каждому элементу коллекции и создаёт пару (Key to Value), из которых автоматически собирает готовый Map.
}

//6. Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и возвращать булево значение.
interface Validator <T> {
    fun validate (element: T) : Boolean
}
//7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator : Validator <String?> {
    override fun validate (string: String?): Boolean {
        return  !string.isNullOrBlank() // проверяем что не пустая и возвращает true если хоть 1 параметр не проходит
            }
}
//8. Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator: Validator<Int> {
    override fun validate(element: Int): Boolean {
        return element % 2 == 0
    }
}
//9. Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
class ListValidator <T: Number> : Validator<List<T?>> {
    override fun validate(element: List<T?>): Boolean {
        return element.all { it != null && it.toDouble() != 0.0 }
    }
}


