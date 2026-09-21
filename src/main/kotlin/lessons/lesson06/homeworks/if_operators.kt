package org.example.lessons.lesson06.homeworks


/*Задание 1: "Определение сезона"

Напишите функцию, которая на основе номера месяца распечатывает сезон года. Номера месяцев начинаются с единицы.*/
fun seasonDefiner(monthNumber: Int) {
    when (monthNumber) {
        12, in 1 .. 2 -> println("It`s winter")
        in 3..5 -> println("It`s spring")
        in 6 .. 8 -> println("It`s summer")
        in 9 .. 11 -> println("It`s autumn")
        else -> println("Invalid month number")
    }
}
/* Задание 2: "Расчет возраста питомца"

Создайте функцию, которая преобразует возраст собаки в "человеческие" годы. До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам. Результат распечатай в консоль. */
fun dogAgeTransformer(dogAge: Int) {
    var inHumanAge: Double
    if (dogAge in 1..2) {
        inHumanAge = dogAge * 10.5
    } else {
        inHumanAge = (dogAge -2) * 4.0  + 2 * 10.5
    }
    println("the dog is $inHumanAge years old")
}
/* Задание 3: "Определение способа перемещения"
Напишите функцию, которая печатает в консоль, какой способ перемещения лучше использовать, исходя из длины маршрута. Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт". */
fun choosingTransport (rootLength: Double) {
    if (rootLength <= 1.0 ) {println("Go on foot")
    } else if (rootLength <= 5.0) {println("Go by bike")
    } else {println("Use transport")}
    }

/* Задание 4: "Расчет бонусных баллов"
Клиенты интернет-магазина получают бонусные баллы за покупки. Напишите функцию, которая принимает сумму покупки и печатает в консоль количество бонусных баллов: 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 3 балла за каждые 100 рублей при сумме свыше этого. */
fun bonusCounter (purchaseSum: Double) {
    var bonusSum: Int
if (purchaseSum <= 1000) {bonusSum = purchaseSum.toInt() / 100 * 2
}else{bonusSum = purchaseSum.toInt() / 100 * 3}
println("You`ve got $bonusSum bonuses")
}

/*Задание 5: "Определение типа документа"
В системе хранения документов каждый файл имеет расширение. Напишите функцию, которая на основе расширения файла печатает в консоль его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
*/
fun fileTypeDefiner (fileExtension: String) {
    when (fileExtension) {
        ".txt", ".doc", ".docx", ".pdf" -> println("Текстовый документ")
        ".jpg", ".jpeg", ".png", ".gif"  -> println("Изображение")
        ".xls", ".xlsx", ".csv"         -> println("Таблица")
        else                             -> println("Неизвестный тип")
    }
}
/*Задание 6: "Конвертация температуры"
Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот в зависимости от указанной единицы измерения (C/F). Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов передаются через запятую. Распечатай в консоль результат конвертации с добавлением единицы измерения. Чтобы добавить единицу измерения после результата используй функцию печати без переноса строки print("C") или print("F").*/
fun temperatureTransformer (temperature: Int, scale: Char) {
    if (scale == 'F') {
        print((temperature - 32) * 5 / 9)
        println("C")
    } else if (scale == 'C') {
        print(temperature * 9 / 5 + 32)
        println("F")
    } else {
        println("Invalid temperature")
    }
}
/* Задание 7: "Подбор одежды по погоде"
Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды: "куртка и шапка" при температуре ниже +10, "ветровка" от +10 до +18 градусов включительно и "футболка и шорты" при температуре выше +18 градусов. При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
*/
fun clothesRecomend (temperature: Int) {
    if (temperature < -30 || temperature > 35) {
        println("Stay at home")
    } else if (temperature < 10) {
        println("Put on  hat and jacket")
    } else if (temperature in 10..18) {
        println("Put on  wind jacket")
    } else {
        println("Put on T-shirt and shorts")
    }
}
/* Задание 8: "Выбор фильма по возрасту"
Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию, которая принимает возраст зрителя и возвращает доступные для него категории фильмов: "детские" (от 0 до 9), "подростковые" (от 10 до 18), "18+" для остальных. */
fun filmCategory (age: Int) {
    when (age) {
        in 0.. 9 -> println("Choose films for children")
        in 10 until 18 -> println("Choose films for teens")
        in 18 .. 110 -> println("Choose films for adults")
        else -> println("Invalid age")
    }
}
fun main() {
seasonDefiner(13)
dogAgeTransformer(5)
    choosingTransport(0.4)
    bonusCounter(125.5)
    temperatureTransformer(10, 'F')
    clothesRecomend(-45)
    filmCategory(45)
}







