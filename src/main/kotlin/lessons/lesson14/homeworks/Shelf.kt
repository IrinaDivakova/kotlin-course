package org.example.lessons.lesson14.homeworks

class Shelf (
    val capacity: Long,
    var items : MutableList<String>
) {
    fun addItem(item: String): Boolean {
        var itemLength = item
            .trim()
            .replace(" ", "")
            .length
        var currentLength: Int = items.sumOf { it.trim().replace(" ", "").length }
        if (capacity - currentLength >= itemLength) {
            items.add(item)
            return true
        } else {
            return false
        }
    }

    fun removeItem(item: String): Boolean {
        if (items.contains(item)) {
            items.remove(item)
            return true
        } else {
            return false
        }
    }

    fun canAccommodate(item: String): Boolean {
        var itemLength = item
            .trim()
            .replace(" ", "")
            .length
        var currentLength: Int = items.sumOf { it.trim().replace(" ", "").length }
        if (capacity - currentLength >= itemLength) {
            return true
        } else {
            return false
        }
    }

    fun containsItem(item: String): Boolean {
        return items.contains(item)
        }

    fun getItems() : List<String> {
        return items.toList()
    }
}
//ласс Shelf (Полка Стеллажа)
//
//Характеристики:
//
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.
//Методы:
//
//Добавление Предмета (addItem):
//Принимает название предмета.
//1. Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
//Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
//Удаление Предмета (removeItem):
//Принимает название предмета.
//Удаляет предмет, если он найден на полке.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка Вместимости (canAccommodate):
//Принимает название предмета.
//Определяет, вместится ли предмет на полку.
//Возвращает true, если предмет вместится, и false, если места недостаточно.
//Проверка наличия предмета (containsItem):
//Принимает название предмета
//Возвращает true если такой предмет есть
//Получение списка предметов (getItems):
//Возвращает неизменяемый список предметов