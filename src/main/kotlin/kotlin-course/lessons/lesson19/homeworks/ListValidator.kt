package org.example.`kotlin-course`.lessons.lesson19.homeworks

class ListValidator<T : Number> : Validator<List<T?>?> {

    override fun isValid(element: List<T?>?): Boolean {
        // Проверка 1: Список не null
        if (element == null) {
            return false
        }

        // Проверка 2: Ни один элемент не null
        if (element.any { it == null }) {
            return false
        }

        // Проверка 3: Ни один элемент, приведённый к Double, не равен 0.0
        // Элементы уже проверены на null, поэтому используем 'it!!'
        return element.none { it!!.toDouble() == 0.0 }
    }
}