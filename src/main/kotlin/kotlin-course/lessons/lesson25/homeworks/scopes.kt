package org.example.`kotlin-course`.lessons.lesson25.homeworks

//Задание 2: Использование apply для инициализации объекта Employee
//
//Создайте объект Employee и используйте apply для инициализации его полей email и department.
fun main() {
    val newEmployee = Employee("Jack Sparrow", 48, "captain").apply {
        email = "jack@google.sink"
        department = "CEO" }

    println(newEmployee)

//    Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
// Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.
fun personInfo (person: Person) {
    println("*********************************************************")
    with(person){ println("name: $name")
                  println("age: $age")
        println("e-mail: $email")
    println("**************************")
    }
}
//    Создайте объект Person и используйте also для добавления почты и печати данных в консоль с помощью метода который только что создали.
    val newPerson = Person ("Jack Sparrow", 100).also {
        it.email = "fghj@hkjlk.h"
    }
        .also{personInfo(it)}

//Задание 4: Использование with для преобразование Person в Employee
//Создайте объект класса Person.
    val newPerson2 = Person("Fox", 20).apply { email= "gghj@jhjk.com" }
// Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно должность.
   val newCook = with(newPerson2) {
       Employee(name=name, age=age, position = "cook").also {it.email = email
       it.department = "crew"}
   }
    println("a new cook for: $newCook")
// Возвращаемым значением должен быть новый объект Employee.

//  Задание 5: Использование run для преобразования и инициализации Employee
//  Перепиши предыдущую задачу на использование run вместо with.
    val newCook2 = newPerson2.run {
        Employee(name=name, age=age, position = "cook").also {it.email = email
            it.department = "crew"}
    }
    println("a new cook for: $newCook")
// Задание 6: Использование let для безопасного преобразования Person в Employee
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
fun Person?.toEmployee(position: String, depart: String): Employee? {
    return this?.let {
        Employee(it.name, it.age, position).apply {
            email = it.email
            department = depart
        }
    }
}
// В функции используйте функцию let для создания Employee, только если объект Person не null. В противном случае возвращается null
}