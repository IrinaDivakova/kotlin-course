package org.example.lessons31.homeworks

class PhoneNumberFormatter {/**
 * Преобразует входящую строку в формат +7 (XXX) XXX-XX-XX
 * @throws IllegalArgumentException если номер невалидный
 */
fun formatPhoneNumber(input: String): String {
    // 1. Очищаем строку от всех нечисловых знаков
    val digitsOnly = input.replace("\\D".toRegex(), "")

    // 2. Если длина не 10 или 11 знаков - выкидываем исключение
    if (digitsOnly.length != 10 && digitsOnly.length != 11) {
        throw IllegalArgumentException("Номер должен содержать 10 или 11 цифр")
    }

    val resultDigits: String
    if (digitsOnly.length == 11) {
        // 3. Если 11 знаков, проверяем, что начинается на 8 или 7
        if (digitsOnly.startsWith("7") || digitsOnly.startsWith("8")) {
            // Если условие верное, удаляем первый символ
            resultDigits = digitsOnly.substring(1)
        } else {
            throw IllegalArgumentException("11-значный номер должен начинаться с 7 или 8")
        }
    } else {
        // Если 10 знаков, используем как есть
        resultDigits = digitsOnly
    }

    // 4. Создаём фрагменты через substring и вставляем в шаблон
    val areaCode = resultDigits.substring(0, 3)     // XXX
    val mainPart = resultDigits.substring(3, 6)     // XXX
    val firstPair = resultDigits.substring(6, 8)    // XX
    val secondPair = resultDigits.substring(8, 10)  // XX

    return "+7 ($areaCode) $mainPart-$firstPair-$secondPair"
}
}