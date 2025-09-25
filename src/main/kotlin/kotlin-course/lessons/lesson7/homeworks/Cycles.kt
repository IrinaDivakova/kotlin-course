package org.example.`kotlin-course`.lessons.lesson7.homeworks

fun main() {
//Задания для цикла for
//Прямой диапазон
//1. Напишите цикл for, который выводит числа от 1 до 5.
    for (i in 1..5) {
        println("ex.1  i")
    }
//2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0) {
            println("$i is even")
        }
    }
//Обратный диапазон
//3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        print(i)
    }
//4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1 step 2) {
        println("Ex.4 minus two $i")
    }

//С шагом (step)
//5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..9 step 2) {
        println("ex.5 $i")
    }
//6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        print("every 3rd: $i ")
    }
//Использование до (until)
//7.Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 33
    for (i in 3 until size step 2) {
        println(i)
    }
//Задания для цикла while
//Цикл while
//8. Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var b: Int = 1
    while (b <= 5) {
        val square = b * b
        print("square of $b is $square ")
        b++
    }
    println("--------------------------------")
//9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var c: Int = 10
    while (c >= 5) {
        c--
    }
    println("Ex.9 result: $c")
//Цикл do while
//10. Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var d: Int = 5
    do {
        print(d--)
    } while (d in 5 downTo 1)
//11. Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var counter: Int = 5
    do {
        counter++
    } while (counter < 10)
    println("ex.11 counting result: $counter")
//Задания для прерывания и пропуска итерации
//Использование break
//12. Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        print(i)
        if (i == 6) {
            break
        }
    }
    println(" and .... I broke it!")
    //13. Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var g: Int = 1
    while (true) {
        print("count till 10 $g ")
        if (g == 10) {
            break
        }
        g++
    }

//Использование continue
//14. В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.

    for (i in 1..10) {
        if (i % 2 == 0) {
            continue
        }
        println("It`s not even $i")
    }
    println("last ex.")
//15. Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var h: Int = 0
    while (h < 10) {
        h++
        if (h % 3 == 0) {
            continue
        }
        print(h)
    }
}