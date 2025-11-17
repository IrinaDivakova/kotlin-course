package org.example.`kotlin-course`.lessons.lesson19.homeworks
//Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator : Validator<Int> {

    override fun isValid(element: Int): Boolean {
        return element % 2 == 0
    }
}