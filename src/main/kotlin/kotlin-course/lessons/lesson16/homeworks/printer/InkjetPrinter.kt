package org.example.`kotlin-course`.lessons.lesson16.homeworks.printer
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста.
class InkjetPrinter : Printer() {
    override fun printMessage (message: String) {
        val splittedMessage = message.split(" ")
//        val textColours: List<String> = listOf(Colours.PURPLE, Colours.BLUE, Colours.GREEN, Colours.YELLOW, Colours.RED, Colours.CYAN)
//        val backgroundColours: List<String> = listOf(Background.WHITE, Background.RED, Background.YELLOW, Background.WHITE, Background.BLACK, Background.PURPLE)
        val pairOfColours: List<Pair<String, String>> = listOf(
            Colours.PURPLE to Background.WHITE,
            Colours.BLUE to Background.RED,
            Colours.GREEN to Background.YELLOW,
            Colours.YELLOW to  Background.WHITE,
            Colours.RED to Background.BLACK,
            Colours.CYAN to Background.PURPLE   )

// 1. Получаем размер списка и создаем индекс, который будем менять
            val numPairs = pairOfColours.size
            var colorIndex = 0 // ⭐️ Начинаем с 0

           for (word in splittedMessage) {

                // 3. ⭐️ Выбираем текущую пару по colorIndex
                val colours = pairOfColours[colorIndex]

                // Вывод: фон + текст + слово + сброс
                print("${colours.second}${colours.first}$word${Colours.RESET} ")

                // 4. Увеличиваем индекс для СЛЕДУЮЩЕГО слова
                colorIndex++

                // 5. ⭐️ Самое главное: Если индекс достиг конца списка, сбрасываем его на 0
                if (colorIndex >= numPairs) {
                    colorIndex = 0 // Начинаем цикл сначала
                }
            }
            println()
        }
    }
