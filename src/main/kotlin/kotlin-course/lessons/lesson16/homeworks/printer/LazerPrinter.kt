package org.example.`kotlin-course`.lessons.lesson16.homeworks.printer

class LazerPrinter() : Printer () {
    override fun printMessage (message: String) {
        val splittedMessage = message.split(" ")
        for (word in splittedMessage) {
            println("${Background.WHITE}${Colours.BLACK}$word${Background.RESET}")
        }
    }
}