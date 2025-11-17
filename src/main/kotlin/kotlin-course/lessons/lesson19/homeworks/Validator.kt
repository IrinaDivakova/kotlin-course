package org.example.`kotlin-course`.lessons.lesson19.homeworks
//Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и возвращать булево значение.
interface Validator<T> {

    /**
     * Выполняет проверку элемента.
     * @param element Элемент для валидации.
     * @return true, если элемент прошел валидацию, иначе false.
     */
    fun isValid(element: T): Boolean
}