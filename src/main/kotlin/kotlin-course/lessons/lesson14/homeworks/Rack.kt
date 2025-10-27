package org.example.`kotlin-course`.lessons.lesson14.homeworks

//Характеристики:
//
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.

class Rack (private val maxShelves: Int) {

    private val shelves = mutableListOf<Shelf>()

    //Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size == maxShelves) {
            return false
        }
        shelves.add(shelf)
        return true
    }
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
fun removeShelf(index: Int): List<String> {
    if (index !in shelves.indices) {
        return emptyList()
    }
    val items: List<String> = shelves[index].getItems()
    shelves.removeAt(index)
    return items
}

    //Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
    fun addItem(name: String): Boolean {
        if (shelves.isEmpty()) {
            return false
        }
        for (shelf in shelves) {
            if (shelf.canAccommodate(name)) {
                return shelf.addItem(name)
            }
        }
        return false
    }
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
fun removeItem(name: String): Boolean {
    for (shelf in shelves) {
        if (shelf.containsItem(name)) {
            return shelf.removeItem(name)
        }
    }
    return false
}

//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
fun containsItem(name: String): Boolean {
    return shelves.any { it.containsItem(name) }
}
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
fun getShelves() = shelves.toList()
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
fun printContents() {
    for (i in shelves.indices) {
        val capacity = shelves[i].capacity
        val accessiblePlace = capacity - shelves[i].getItems()
            .map { it.length }
            .sum()
        val meta = "$i вместимость: $capacity доступно: $accessiblePlace"
        val items = shelves[i].getItems().joinToString()
        println(meta)
        println("Предметы: $items")
        println()
    }
}
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
//fun advancedRemoveShelf(index: Int): List<String> {
//    if (index !in listOfShelves.indices) {
//        return emptyList()
//    }
//
//    // 1. Удаляем полку и извлекаем ее предметы
//    val itemsToRedistribute = listOfShelves.removeAt(index).getItems()
//
//    val remainingItems = mutableListOf<String>()
//
//    // 3. Перераспределяем предметы
//    for (item in itemsToRedistribute) {
//        var added = false
//        for (shelf in listOfShelves) {
//            if (shelf.addItem(item)) {
//                added = true
//                break
//            }
//        }
//
//        // 4. Если предмет не поместился ни на одну из оставшихся полок
//        if (!added) {
//            remainingItems.add(item)
//        }
//    }
//
//    // 5. Возвращаем предметы, которые не удалось разместить.
//    return remainingItems.toList()
//}
fun advancedRemoveShelf(index: Int): List<String> {
    if (index !in shelves.indices) {
        return emptyList()
    }
    val notReplacedItems = mutableListOf<String>()
    val otherShelves = shelves - shelves[index]
    for (item in shelves[index].getItems()) {
        if (otherShelves.none { it.addItem(item) }) {
            notReplacedItems.add(item)
        }
    }
    shelves.removeAt(index)
    return notReplacedItems.toList()
}
}