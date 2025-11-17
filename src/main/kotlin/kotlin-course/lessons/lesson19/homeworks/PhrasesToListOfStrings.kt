package org.example.`kotlin-course`.lessons.lesson19.homeworks
//Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>. Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков с аналогичной механикой.
class PhrasesToListOfStrings : Mapper<String, List<String>> {

//    Разбивает входящую строку по символу пробела и возвращает список слов.

    override fun map(input: String): List<String> {
        return input.split(" ")
    }
//        * Преобразует список строк, разбивая каждую строку по пробелу,
//     * и возвращает список списков слов.

    override fun mapList(inputList: List<String>): List<List<String>> {
        return inputList.map { inputString ->
            map(inputString)
        }
    }
}