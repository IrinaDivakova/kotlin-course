package org.example.`kotlin-course`.lessons.lesson13.homeworks

import org.example.`kotlin-course`.kotlin.lesson.e

fun main() {


//1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
//val mapNameTime = mutableMapOf<String, Int>()
//   val listOfValues = mapNameTime.values
//    println(listOfValues.average())
    val mapNameTime = mapOf("Test_Login" to 5,
    "Test_Checkout" to 12,
    "Test_Cart" to 7,
    "Test_Search" to 8)
    println(mapNameTime.values.average())
//2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными. Выведите список всех тестовых методов.
    val ex2 = mapOf("Test_Login_UI" to "Priority: High, Owner: Team_A, Type: UI",
        "Test_DB_Connection" to "Priority: Low, Owner: Infra_Team, Type: Integration",
        "Test_API_Checkout" to "Priority: Critical, Owner: Team_B, Type: Functional")
    println("ex/2 ${ex2.keys}")
//3.В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val ex3 = mutableMapOf("Test_Login_UI" to "Priority: High, Owner: Team_A, Type: UI",
        "Test_DB_Connection" to "Priority: Low, Owner: Infra_Team, Type: Integration",
        "Test_API_Checkout" to "Priority: Critical, Owner: Team_B, Type: Functional")
   ex3["Test_Login_UI_2"] = "Priority: High, Owner: Team_B, Type: UI"
    println("ex3: $ex3")
//4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
    val ex4 = mapOf("Test_1" to "Passed", "Test_2" to "Passed", "Test_3" to "Failed", "Test_4" to "Failed", "Test_5" to "Passed", "Test_6" to "Skipped")
   val result = ex4.values.filter { it =="Passed"}.count()
    println("ex4: $result")
//5.Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    val ex5 = mutableMapOf("Test_1" to "Done", "Test_2" to "In progress", "Test_3" to "Done", "Test_4" to "In progress", "Test_5" to "Passed", "Test_6" to "Skipped")
    ex5.entries.removeAll {it.value == "Passed" }
 println("ex5: $ex5")
//6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
val ex6 = mutableMapOf("https://example.com/home" to 200,
    "https://example.com/products" to 200,
    "https://example.com/broken_link" to 404,
    "https://example.com/internal_error" to 500)
    println(ex6.entries)
    ex6.forEach{ (k, v) -> println(" page $k - status: $v") }
//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val executingTime = 350.8
    val  ex7 = mapOf("Auth_Service" to 450.5,
    "User_Data_API" to 120.0,
    "Payment_Gateway" to 1020.75,
    "Notification_Queue" to 55.3,
    "Reporting_Engine" to 2500.0)
    println("ex.7: ${ex7.filterValues { it > executingTime  }}")
//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки). Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val ex8 = mapOf(
        "api/v1/users" to "200 OK",
        "api/v1/products" to "403 Forbidden",
        "api/v1/checkout" to "500 Server Error",
        "api/v1/reports" to "200 OK"
    )
    val endpointToFind = "api/v1/reports"
    ex8.getOrDefault(endpointToFind, "Isn`t tested")
//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val ex9 = mapOf(
        "environment" to "staging",
        "browserType" to "Chrome",
        "headless" to "true",
        "screenshotOnFail" to "true"
    )
    val valueToFind = "browserType"
    ex9.getValue(valueToFind)
//10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val ex10 = mapOf(
        "1.0.0" to "2024-01-15",
        "1.0.1" to "2024-02-20",
        "1.1.0" to "2024-03-10"
    )
ex10 + ("1.1.12" to "2024-03-18")
//11. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val ex11 = mapOf(
        "iPhone 15" to "iOS 17, Resolution: Max",
        "Samsung S23" to "Android 14, Resolution: Medium",
        "iPad Pro" to "iOS 17, Resolution: Large"
    )
    val keyToUse = "iPad Pro"
    ex11.getOrElse(keyToUse) {"Default settings"}
//12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val ex12 = mapOf(
        1001 to "Invalid input data",
        2005 to "Timeout exceeded",
        401 to "Authentication failed"
    )
    val keyToFind12 = 102
    ex12.containsKey(keyToFind12)
//13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val ex13 = mapOf(
        "Login_V1_1_Success" to "Passed",
        "Checkout_V1_2_Failed" to "Failed",
        "Report_V1_2_Skipped" to "Skipped",
        "Profile_V1_1_Passed" to "Passed",
        "Settings_V1_2_Passed" to "Passed"
    )
    val version = "Success"
    ex13.filterKeys { it.contains(version) }
//14. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val ex14 = mapOf(
        "Authentication" to "Passed",
        "Payment" to "Passed",
        "Reporting" to "Failed",
        "Notifications" to "Passed"
    )
    ex14.containsValue("Failed")
//15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val ex15_Mutable = mutableMapOf(
        "timeout" to 30000,
        "retryCount" to 3
    )
    val settingsToAdd15 = mapOf(
        "timeout" to 60000,
        "environment" to 4785
    )
ex15_Mutable.putAll(settingsToAdd15)
//16. Объедините два неизменяемых словаря с данными о багах.
    val ex16_A = mapOf(
        "BUG_001" to "Critical",
        "BUG_002" to "Minor"
    )
    val ex16_B = mapOf(
        "BUG_003" to "Major",
        "BUG_001" to "Major" // Перезапишет BUG_001 из A
    )
    ex16_A + ex16_B
//17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val ex17_Mutable = mutableMapOf(
        "LastRun" to "2024-09-01",
        "TotalTests" to "150",
        "FailedTests" to "10"
    )
    ex17_Mutable.clear()
//18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val ex18 = mapOf(
        "Login_Test" to "Passed",
        "Logout_Test" to "Skipped",
        "Payment_Test" to "Failed",
        "Report_Test" to "Skipped"
    )
    val status18 = "Skipped"
    ex18.filterValues { it != status18 }

//19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val ex19 = mapOf(
        "DB_URL" to "jdbc:...",
        "API_Key" to "xyz123",
        "Environment" to "QA"
    )
    val keysToRemove = listOf( "API_Key", "Environment")
    ex19 - keysToRemove
//20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val ex20 = mapOf(
        101 to "Passed",
        102 to "Failed",
        103 to "Passed"
    )
    val ListFromMap: List<String> = ex20.map { (id, result) ->
                "Test ID $id: $result"
    }

//21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val ex21_Mutable = mutableMapOf(
        1 to "Passed",
        2 to "Failed"
    )
    ex21_Mutable.toMap()
//22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val ex22 = mapOf(
        100 to 15.5,
        101 to 22.0,
        102 to 5.1
    )
    val newMap22 = ex22.mapKeys { "Test ${it.toString()}" }
//23. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val ex23 = mapOf(
        "v1.0" to 100.0,
        "v1.1" to 120.0,
        "v2.0" to 95.5
    )
    val newConditions = ex23.mapValues { it.value * 1.1 }
//24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val ex24 = mapOf<Int, String>()
    ex24.isEmpty()

//25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val ex25 = mapOf(
        "DB_Stress" to "OK",
        "CPU_Load" to "Warning"
    )
    ex25.isNotEmpty()
//26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val ex26 = mapOf(
        "Test A" to "Passed",
        "Test B" to "Passed",
        "Test C" to "Passed"
    )
    ex26.all { it.value == "Passed"}
//27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    val ex27 = mapOf(
        "Login" to "Passed",
        "Payment" to "Passed",
        "Report" to "Failed",
        "Profile" to "Passed"
    )
    ex27.any { it.value == "Failed" }
//28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
    val ex28 = mapOf(
        "Login_Test" to "Passed",
        "Optional_UI_Test" to "Failed",
        "Critical_DB_Test" to "Failed",
        "Optional_Report_Test" to "Skipped"
    )
    ex28.filter { it.key.contains("optional", ignoreCase = true) && it.value == "Failed" }

}