package org.example.`kotlin-course`.lessons.lesson06.homeworks

import org.example.`kotlin-course`.kotlin.lesson.p

/* Задание 1: "Определение сезона"
Напишите функцию, которая на основе номера месяца распечатывает сезон года. Номера месяцев начинаются с единицы.*/
//val monthNumber: Int? = 2
fun season (monthNumber: Int) {
    if (monthNumber in 3..5) {
        println("it`s spring")
    } else if (monthNumber in 6..8) {
        println("it`s summer")
    } else if (monthNumber in 9..11) {
        println("it`s autumn")
    } else {
        println("it`s winter")
    }
}
fun season2 (monthNumber: Int) {
    when (monthNumber) {
        in 3..5 -> println("it`s spring")
        in 6..8 -> println("it`s summer")
        in 9..11 -> println("it`s autumn")
        else -> println("it`s winter")
    }
}
/* Задание 2: "Расчет возраста питомца"
Создайте функцию, которая преобразует возраст собаки в "человеческие" годы. До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам. Результат распечатай в консоль.*/
fun dogAgeAsaHuman (dogAge: Int) {
    if (dogAge <= 2) {
        println(dogAge * 10.5)
    } else {
        println (21 + (dogAge -2)*4)
    }
}
/* Задание 3: "Определение способа перемещения"
Напишите функцию, которая печатает в консоль, какой способ перемещения лучше использовать, исходя из длины маршрута. Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".*/
fun whatToUse (routLength: Double) {
    if (routLength < 1.0) {
        println("have a walk")
    } else if (routLength >=1.0 && routLength < 5.0) {
        println("take a bike")
    } else {
        println("use transport")
    }
}
/* Задание 4: "Расчет бонусных баллов"
Клиенты интернет-магазина получают бонусные баллы за покупки. Напишите функцию, которая принимает сумму покупки и печатает в консоль количество бонусных баллов: 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 3 балла за каждые 100 рублей при сумме свыше этого.*/
fun bonuses (purchaseSum: Double) {
    when {
        purchaseSum < 1000.00 -> println(purchaseSum / 100 * 2)
        else -> println(purchaseSum/100 *3)
    }
}
/* Задание 5: "Определение типа документа"
В системе хранения документов каждый файл имеет расширение. Напишите функцию, которая на основе расширения файла печатает в консоль его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".*/
fun docType (lettersAfterDot: String) {
    when (lettersAfterDot) {
        "txt" -> println(" It`s a text document")
        "xls" -> println(" It`s a table")
        "svg", "jpg", "img" -> println(" It`s an image")
        else -> println("the type is unknown")
    }
}
/* Задание 6: "Конвертация температуры"
Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот в зависимости от указанной единицы измерения (C/F). Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов передаются через запятую. Распечатай в консоль результат конвертации с добавлением единицы измерения. Чтобы добавить единицу измерения после результата используй функцию печати без переноса строки print("C") или print("F").*/
fun temperatureConvert (grade: Int, system: Char) {
    if (system == 'C') {
        print(grade * 1.8 + 32)
        println(" F")
    } else {
        print((grade - 32) / 1.8)
        println(" C")
    }
}
/* Задание 7: "Подбор одежды по погоде"

Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды: "куртка и шапка" при температуре ниже +10, "ветровка" от +10 до +18 градусов включительно и "футболка и шорты" при температуре выше +18 градусов. При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.*/
fun weatherRecommend (temperature: Int) {
    when {
        temperature < -30 || temperature > 35 -> println("Stay at home")
        temperature < 10 -> println("Put on a jacket and a hat")
        temperature in 10..18 -> println("Put on a coat")
        else -> println("Put on a T-shirt and a cap")
        }
}
/* Задание 8: "Выбор фильма по возрасту"
Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию, которая принимает возраст зрителя и возвращает доступные для него категории фильмов: "детские" (от 0 до 9), "подростковые" (от 10 до 18), "18+" для остальных.*/
fun filmCategory (age: Int) {
    when (age) {
        in 0..9 -> println("детские")
        in 10 until 18 -> println("подростковые")
        else -> println("18+")
    }
}
fun main() {
    temperatureConvert(30, 'C')
    dogAgeAsaHuman(1)
}