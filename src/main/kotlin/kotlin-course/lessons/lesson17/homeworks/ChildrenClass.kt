package org.example.`kotlin-course`.lessons.lesson17.homeworks

import org.example.`kotlin-course`.lessons.lesson17.homeworks.BaseClass

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
//    наследуется из родительского класса (BaseClass) как публичное поле. параметр конструктора
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    override fun verifyPublicField(value: String): Boolean {
        return true
    } // ex/4 Теперь разрешено любое значени

    fun setProtectedFieldFromMain(value: String) {
        protectedField = value
    } // ex5

    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

