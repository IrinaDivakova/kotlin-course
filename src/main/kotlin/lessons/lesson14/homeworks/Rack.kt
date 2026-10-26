package org.example.lessons.lesson14.homeworks

class Rack(
    val shelves: MutableList<Shelf>,
    val maxCapacity: Int)
{
    //Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
    fun addShelf(shelf: Shelf): Boolean { //Добавление Полки ():
        var currentCapacity: Int = shelves.size
        if (shelves.contains(shelf) || (maxCapacity - currentCapacity < 1)) {
            return false
        } else {
            shelves.add(shelf)
            return true
        }
    }
    //Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
    fun removeShelf(index: Int): List<String> {
        if (index in shelves.indices) {
            val shelfItems = shelves[index].getItems()
            shelves.removeAt(index)
            return shelfItems
        } else {
            return emptyList()
        }
    }

//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
fun addItem(item: String): Boolean {
val emptyShelf = shelves.firstOrNull { shelf -> shelf.addItem(item)} // Если полка найдена (не null), значит предмет успешно добавлен -> возвращаем true

    return emptyShelf != null // Если null (нет свободных полок) -> возвращаем false
    }



//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
fun removeItem (item: String): Boolean{
    // 1. Ищем первую полку, на которой есть этот предмет, используя ваш метод containsItem
    val shelf = shelves.firstOrNull { it.containsItem(item) }

    // 2. Если полка найдена:
    if (shelf != null) {
        // Удаляем предмет с этой полки и возвращаем true
        // (Предполагается, что у Shelf есть метод removeItem или мы удаляем из MutableList)
        return shelf.removeItem(item)
    }

    // 3. Если полка не нашлась, значит предмета нет на стеллаже
    return false
}
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
fun containsItem(item: String): Boolean {
    return shelves.any { it.containsItem(item) }
}
    //Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
}