package org.example.`kotlin-course`.lessons.lesson16.homeworks.basket
//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.
class Basket (val items: MutableMap<Int,Int> = mutableMapOf()) {
    fun addToCart(itemId: Int) {
        if (items.containsKey(itemId)) {
            items[itemId] = items[itemId]!! + 1
        } else {
            items[itemId] = 1
        }
    }
    fun addToCart(itemId: Int, amount:Int) {
        if (items.containsKey(itemId)) {
            items[itemId] = items[itemId]!! + amount
        } else {
            items[itemId] = amount
        }

    }
    fun addToCart( listOfItems: MutableMap<Int,Int>) {
        for ((itemId, amount) in listOfItems) {
            addToCart(itemId, amount)
        }
    }
    fun addToCart(listOfID: List<Int>) {
        for (i in listOfID) {
            addToCart(i)
        }
    }
    override fun toString(): String {
        if (items.isEmpty()) {
            return "Корзина пуста."
        }

        // 1. Собираем список товаров в виде "ID: Количество"
        val itemDetails = items.map { (id, amount) ->
            "ID $id: $amount шт."
        }.joinToString(separator = ", ") // Соединяем запятыми

        // 2. Подсчитываем итоги
        val totalUniqueItems = items.size
        val totalAmount = items.values.sum()

        // 3. Собираем финальный отчет (просто текст)
        return """
            --- СОДЕРЖИМОЕ КОРЗИНЫ ---
            Товары: [$itemDetails]
            Всего уникальных артикулов: $totalUniqueItems
            Общее количество всех единиц: $totalAmount
            ----------------------------
        """.trimIndent()
    }
}