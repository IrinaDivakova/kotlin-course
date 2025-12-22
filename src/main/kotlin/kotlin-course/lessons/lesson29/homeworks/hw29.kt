package org.example.`kotlin-course`.lessons.lesson29.homeworks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

//Создай дата класс сотрудника компании Employee, содержащий:

//имя
//статус трудоустройства (булево)
//дата рождения (строка)
//должность CharacterTypes
//список подчинённых с типом Employee

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val birthDate: String,
    val position: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)
enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}
//Задание 2
//
//Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк) и у каждого было по группе сотрудников подходящего для его стека профиля.
//
val frontendTeamLead = Employee(
    name = "Alice",
    isEmployed = true,
    birthDate = "1990-03-12",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(
        Employee(
            name = "Bob",
            isEmployed = true,
            birthDate = "1995-06-21",
            position = CharacterTypes.UX_UI
        ),
        Employee(
            name = "Charlie",
            isEmployed = true,
            birthDate = "1993-11-02",
            position = CharacterTypes.FRONTEND_DEV
        ),
        Employee(
            name = "Diana",
            isEmployed = true,
            birthDate = "1996-01-17",
            position = CharacterTypes.QA
        )
    )
)
val backendTeamLead = Employee(
    name = "Ethan",
    isEmployed = true,
    birthDate = "1988-09-08",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(
        Employee(
            name = "Frank",
            isEmployed = true,
            birthDate = "1992-04-30",
            position = CharacterTypes.BACKEND_DEV
        ),
        Employee(
            name = "Grace",
            isEmployed = true,
            birthDate = "1994-07-14",
            position = CharacterTypes.BACKEND_DEV
        ),
        Employee(
            name = "Helen",
            isEmployed = true,
            birthDate = "1991-12-05",
            position = CharacterTypes.QA
        ),
        Employee(
            name = "Ivan",
            isEmployed = true,
            birthDate = "1989-02-19",
            position = CharacterTypes.SYSADMIN
        )
    )
)
val pm = Employee(
    name = "Michael",
    isEmployed = true,
    birthDate = "1987-05-10",
    position = CharacterTypes.PM,
    subordinates = listOf(frontendTeamLead, backendTeamLead)
)
val crm = Employee(
    name = "Sophia",
    isEmployed = true,
    birthDate = "1991-08-23",
    position = CharacterTypes.CRM
)
val cto = Employee(
    name = "Oliver",
    isEmployed = true,
    birthDate = "1985-01-01",
    position = CharacterTypes.CTO,
    subordinates = listOf(pm, crm)
)
//Задание 3
//
//Создай функцию в которой:
//
//сериализуй CTO в текст с настройкой prettyPrinting
//текст запиши в файл в корне проекта.

fun ex3() {
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson.toJson(cto).also {
        File("structure.json").writeText(it)
    }
}
//Задание 4
//
//Создай функцию в которой:
//
fun ex4() {
    val gson = Gson()
    val json = File("structure.json").readText()
    val cto = gson.fromJson(json, Employee::class.java)
    println(cto)
    // Задание 5
    ex5(cto).groupBy { it.position }
        .map { group -> "${group.key}: ${group.value.joinToString { it.name }}" }
        .forEach { println(it) }
}
//прочитай текст из файла
//десериализуй его в объект класса Employee
//распечатай в консоль
//Задание 5
//
fun ex5(arg: Employee): List<Employee> {
    return if (arg.subordinates.isNotEmpty()) {
        arg.subordinates
            .flatMap {
                ex5(it)
            } + arg.copy(subordinates = emptyList())
    } else {
        listOf(arg)
    }
}
//Для любителей алгоритмов. Не обязательное для выполнения.
//
//Прочитай текст из файла и десериализуй в объект класса Employee.
//Сгруппируй всех сотрудников по их должности.
//Выведи в консоль в виде секций: должность и имена сотрудников через запятую.
//Получение всех сотрудников выполняется через рекурсивную функцию, которая принимает объект Employee а возвращает список всех Employee без вложений.