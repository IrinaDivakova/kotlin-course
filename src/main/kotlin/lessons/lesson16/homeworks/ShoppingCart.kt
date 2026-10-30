package org.example.lessons.lesson16.homeworks

//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.

class ShoppingCart (
    private var shoppingList: MutableMap<String, Int >
){
    fun addToCart(itemId: String) {
        shoppingList[itemId] = (shoppingList[itemId] ?: 0 ) +1

    }
    fun addToCart(itemId: String, amount: Int) {
        shoppingList[itemId] = (shoppingList[itemId] ?: 0 ) + amount
    }
    fun addToCart(newItems: Map<String, Int>) {
        newItems.forEach { (itemId, amount) ->
            // Берём текущее количество, а если его нет — берём 0, и прибавляем amount
            val currentAmount = shoppingList.getOrDefault(itemId, 0)
            shoppingList[itemId] = currentAmount + amount
        }
    }
    fun addToCart(newItems: List<String>) {
        newItems.forEach { itemId ->
            val currantAmount = shoppingList.getOrDefault(itemId, 0)
            shoppingList[itemId] = currantAmount + 1
        }

    }
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.
override fun toString(): String {
    val stringBuilder = StringBuilder()
for (it in shoppingList) {

    stringBuilder.appendLine("${it.key.padEnd(38)} | ${it.value.toString().padStart(8)} ")
}
    val totalArticles = shoppingList.size
    val totalItems = shoppingList.values.sum()
    stringBuilder.appendLine( "Всего артикулов: ${totalArticles.toString().padEnd(20)} | Всего товаров: ${totalItems.toString().padStart(1)}")
return stringBuilder.toString()

}
}

fun main() {

val cart = ShoppingCart(mutableMapOf())

// 1. Добавляем по одному ID
cart.addToCart("APPLE-001")
cart.addToCart("APPLE-001") // Теперь их 2

// 2. Добавляем ID и конкретное количество
cart.addToCart("MILK-500", 3)
cart.addToCart("BREAD-01", 5)

// 3. Добавляем словарь товаров (3-й метод)
val mapToAdd = mapOf(
    "MILK-500" to 2,   // MILK-500 станет 3 + 2 = 5
    "COFFEE-99" to 1
)
cart.addToCart(mapToAdd)

// 4. Добавляем список ID (4-й метод)
val listToAdd = listOf("APPLE-001", "TEA-123", "TEA-123")
cart.addToCart(listToAdd)


println(cart)
}