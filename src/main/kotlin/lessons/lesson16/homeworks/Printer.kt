package org.example.lessons.lesson16.homeworks


//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте
abstract class Printer {
    open fun print(file: String) {
        println(file)
    }
}

class LaserPrinter () : Printer () {
    override fun print(file: String) {
        file.split(" ").forEach { println("${Colors.BLACK}${Background.WHITE} $it ${Colors.RESET}") }
    }
}
class InkjetPrinter() : Printer() {
    override fun print(file: String) {
        val colors = listOf(
            Colors.RED to Background.BLUE,
            Colors.PURPLE to Background.CYAN,
            Colors.YELLOW to Background.BLACK,
            Colors.GREEN to Background.PURPLE,
            Colors.BLACK to Background.YELLOW
        )
        file.split(" ").forEachIndexed { index, word ->
            val colorPair = colors[index % colors.size]
            println("${colorPair.first} ${colorPair.second} $word ${Colors.RESET}")
        }
    }

}

fun main() {
    val file = "Ужас та какой! зачем я это делаю! я же ничеего не понимаю... "
    val hp1000 = LaserPrinter()
    val hp4578 = InkjetPrinter()
    hp1000.print(file)
    hp4578.print(file)


}
