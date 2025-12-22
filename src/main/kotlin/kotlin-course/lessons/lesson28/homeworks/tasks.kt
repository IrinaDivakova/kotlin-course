package org.example.`kotlin-course`.lessons.lesson28.homeworks

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.Temporal
import java.time.temporal.TemporalAccessor

fun main() {


//    Создай текущую метку времени и выведи её на печать(чтобы ещё раз запомнить название этого класса)
    val t1 = Instant.now()
    println(t1)
//Создай дату своего дня рождения.
    val t2 = LocalDate.of(1985, 10, 26)
//Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val t3 = Period.between(t2, LocalDate.now())
    println(t3.years)
//Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс.
// Temporal - это общий тип для разных классов даты-времени.
// В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте.
// Обработай в методе все типы дат, которые знаешь.
// Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции.
    val date = LocalDate.of(2025, 12, 22)
    val time = LocalTime.of(15, 51, 12)

//Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше. Не используй в них метод now()
    printFormatted(date)
    printFormatted(time)
//Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую,
// к какому поколению принадлежит человек родившийся в эту дату:
// "Бумер" для тех, кто родился с 1946 по 1964 год включительно, и
// "Зумер" для тех, кто родился с 1997 по 2012 год включительно.
// Если дата рождения не попадает ни в один из этих диапазонов, функция должна печатать "Не определено".
// Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate) или проверку вхождения в диапазон. Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.
//
// Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату в месяц и день.
    val t71 = LocalDate.of(2023, 2, 25)
    val t72 = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("MM-dd")
//Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println(t71.plusDays(10).format(formatter))
//Выведи вторую отформатированную дату, прибавив к ней 10 дней. На
// йди отличия)))
    println(t72.plusDays(10).format(formatter))
}

fun printFormatted(arg: Temporal) {
    when (arg) {
        is LocalDate -> "dd-MM-YYYY"
        is LocalTime -> "HH:mm:ss"
        is LocalDateTime -> "dd-MM-YYYY HH:mm:ss"
        is ZonedDateTime -> "dd-MM-YYYY HH:mm:ss z"
        is OffsetDateTime -> "dd-MM-YYYY HH:mm:ss ZZZ"
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }.let {
        DateTimeFormatter.ofPattern(it).format(arg)
    }.also { println(it) }
}
fun printFormattedISO(arg: TemporalAccessor) {
    val formatter = when {
        // Есть и дата, и время, и зона
        arg.isSupported(ChronoField.OFFSET_SECONDS) && arg.isSupported(ChronoField.HOUR_OF_DAY) ->
            DateTimeFormatter.ISO_ZONED_DATE_TIME

        // Есть дата и время, но нет зоны
        arg.isSupported(ChronoField.HOUR_OF_DAY) && arg.isSupported(ChronoField.DAY_OF_MONTH) ->
            DateTimeFormatter.ISO_LOCAL_DATE_TIME

        // Только дата
        arg.isSupported(ChronoField.DAY_OF_MONTH) ->
            DateTimeFormatter.ISO_LOCAL_DATE

        // Только время
        arg.isSupported(ChronoField.HOUR_OF_DAY) ->
            DateTimeFormatter.ISO_LOCAL_TIME

        else -> DateTimeFormatter.ISO_ORDINAL_DATE
    }

    println(formatter.format(arg))
}

private val BOOMER_START = LocalDate.of(1946, 1, 1)
private val BOOMER_END = LocalDate.of(1964, 12, 31)

private val ZOOMER_START = LocalDate.of(1997, 1, 1)
private val ZOOMER_END = LocalDate.of(2012, 12, 31)
fun LocalDate.identifyGeneration() {
    val result = when {
        // Проверка через вхождение в диапазон (использует compareTo внутри)
        this in BOOMER_START..BOOMER_END -> "Бумер"

        // Проверка через методы isAfter/isBefore (включая границы)
        (this.isAfter(ZOOMER_START.minusDays(1)) &&
                this.isBefore(ZOOMER_END.plusDays(1))) -> "Зумер"

        else -> "Не определено"
    }

    println(result)
}