package org.example.lessons.lesson17.homeworks

abstract class BaseClass(
    private val privateVal: String,
    protected val protectedVal: String,
    val publicVal: String
) {

    var publicField = "Начальное значение publicField"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "Начальное значение protectedField"
    private var privateField = "Начальное значение privateField"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate()
        ).map {
            "${it.key}: ${it.value}"
        }.joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass()

    private class PrivateClass()
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    fun changeProtectedField(value: String) {
        protectedField = value
    }

    override fun verifyPublicField(value: String): Boolean {
        return value == "Антонио Бандерас"
    }

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

fun main() {
    val child = ChildrenClass(
        "Private value",
        "Protected value",
        "Public value"
    )

    println(child.privateVal)

    child.publicField = "Антонио Бандерас"

    child.changeProtectedField("Новое protected значение")

    println(child.getAll())

    child.printText()
}