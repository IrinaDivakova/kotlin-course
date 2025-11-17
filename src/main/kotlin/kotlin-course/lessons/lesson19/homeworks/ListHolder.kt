package org.example.`kotlin-course`.lessons.lesson19.homeworks

//Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T> {
    private val elements: MutableList<T> = mutableListOf()
    fun addElement(element: T) {
        elements.add(element)
    }
    fun getAllElements(): List<T> {
        return elements.toList() // toList() возвращает неизменяемую копию
    }
}