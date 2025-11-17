package org.example.`kotlin-course`.lessons.lesson19.homeworks
//Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.
class StringValidator : Validator<String?> {

         override fun isValid(element: String?): Boolean {
        return element != null && element.isNotBlank()
    }
}