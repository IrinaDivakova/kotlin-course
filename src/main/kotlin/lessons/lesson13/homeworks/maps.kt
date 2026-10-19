package org.example.lessons.lesson13.classwork

fun main() {

    val testExecutionTimes = mapOf(
        "testUserLogin" to 1.25,
        "testCheckoutProcess" to 4.50,
        "testProfileUpdate" to 2.10,
        "testSearchProduct" to 0.85
    )
//1.Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    var averageTime = testExecutionTimes.values.average()
    println(averageTime)


//2.Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными. Выведите список всех тестовых методов.
    val testMetadata = mapOf(
        "testUserLogin" to "Author: Анна, Priority: High, Category: Auth",
        "testCheckoutProcess" to "Author: Иван, Priority: Critical, Category: E2E",
        "testProfileUpdate" to "Author: Мария, Priority: Medium, Category: User"
    )
    var testslist = testMetadata.keys
    println(testslist)

//3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val testResults = mutableMapOf(
        "testUserLogin" to "passed",
        "testCheckoutProcess" to "failed",
        "testProfileUpdate" to "skipped",
        "testSearchProduct" to "passed"
    )

    var testResultPlus = testResults + ("testUserSignUp" to "failed")
    println(testResultPlus)
//4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
 var testsPassed = testResultPlus.values.count{ it == "passed"}
    println(testsPassed)

 //5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    var bugTracker = mutableMapOf(
        "BUG-101: NullPointerException on login" to "Fixed",
        "BUG-102: Incorrect total price calculation" to "In Progress",
        "BUG-103: Button overlap on mobile view" to "Open"
    )

    bugTracker.entries.removeIf { it.value == "Fixed"}
    println(bugTracker)

    //6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
    val webPageStatuses = mapOf(
        "https://example.com/login" to "200 OK",
        "https://example.com/dashboard" to "200 OK",
        "https://example.com/admin" to "403 Forbidden",
        "https://example.com/old-page" to "404 Not Found"
    )
    webPageStatuses.forEach { (key, value) ->
        println("Страница: $key, статус проверки: $value")}

//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val serviceResponseTimes = mapOf(
        "AuthService" to 0.45,
        "PaymentService" to 1.20,
        "NotificationService" to 0.15,
        "ReportService" to 3.50
    )
    var time = 2.0
    var result = serviceResponseTimes.filter { (key, value) -> value > time }

//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки). Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val apiResults = mapOf(
        "/api/v1/login" to "200 OK",
        "/api/v1/users" to "500 Internal Server Error",
        "/api/v1/products" to "200 OK"
    )
   val status = apiResults.getOrDefault("/api/v1/login", "wasn`t tested")
println(status)

//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val testConfig = mapOf(
        "env" to "staging",
        "baseUrl" to "https://staging.api.example.com",
        "timeoutSeconds" to "30",
        "browser" to "chrome",
        "headlessMode" to "true"
    )
    val ex9 = testConfig.getOrDefault("opera", "edge")
    println("ex.9 -  $ex9")

 //10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val softwareVersions = mapOf(
        "Frontend" to "v2.14.0",
        "Backend API" to "v1.8.5",
        "Database" to "v12.4",
        "Mobile App" to "v3.0.1"
    )
    var newSoftearVersions = softwareVersions.toMutableMap() + ("Analytics" to "v1.0.0")
println("ex.10 new map $newSoftearVersions")
 //12. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val mobileDeviceConfigs = mapOf(
        "iPhone 14" to "OS: iOS 16, Browser: Safari, Orientation: Portrait",
        "Samsung Galaxy S23" to "OS: Android 13, Browser: Chrome, Orientation: Portrait",
        "Google Pixel 7" to "OS: Android 13, Browser: Chrome, Orientation: Landscape"
    )
    var targetDevice = "Xiaomi Mi 11"
    var result12 = mobileDeviceConfigs.getOrElse(targetDevice) { println("Устройство $targetDevice не найдено, используем стандартный профиль OS: Android 12, Browser: Chrome, Orientation: Portrait") }
println(result12)

    //1
//13. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val testErrors = mapOf(
        400 to "Bad Request: Неверный формат отправленных данных",
        401 to "Unauthorized: Отсутствует или недействителен токен авторизации",
        403 to "Forbidden: Доступ к ресурсу запрещен",
        404 to "Not Found: Запрашиваемый эндпоинт или ресурс не найден",
        500 to "Internal Server Error: Критическая ошибка на стороне сервера"
    )
testErrors.containsKey(406)

//14. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val testExecutionResults = mapOf(
        "TC_001_v1" to "Passed",
        "TC_002_v1" to "Failed",
        "TC_003_v2" to "Passed",
        "TC_004_v1" to "Skipped",
        "TC_005_v2" to "Failed"
    )
    testExecutionResults.filterKeys { it.contains("v2") }
    println(testExecutionResults)

//15. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val moduleTestResults = mapOf(
        "Authentication" to "Passed",
        "Billing" to "Failed",
        "User Profile" to "Passed",
        "Catalog" to "Passed",
        "Checkout" to "Skipped"
    )
    moduleTestResults.containsValue("Failed")

//16. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val baseConfig = mutableMapOf(
        "env" to "staging",
        "timeoutSeconds" to "30"
    )
    val extraConfig = mapOf(
        "browser" to "chrome",
        "headlessMode" to "true"
    )
    baseConfig.putAll(extraConfig)
    // baseConfig += extraConfig
    println(baseConfig)
//17. Объедините два неизменяемых словаря с данными о багах.
    val criticalBugs = mapOf(
        "BUG-101" to "Crash on login screen",
        "BUG-102" to "Payment gateway timeout"
    )
    val minorBugs = mapOf(
        "BUG-103" to "Typo in header text",
        "BUG-104" to "Avatar image not loading"
    )
val newMap = criticalBugs + minorBugs
    println(newMap)

//18. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val lastTestRunData = mutableMapOf(
        "runId" to "RUN-8842",
        "totalTests" to "150",
        "passedTests" to "142",
        "failedTests" to "8",
        "duration" to "12m 30s",
        "status" to "In Progress"
    )
    lastTestRunData.clear()
    println("empty map: $lastTestRunData")
//19. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val testReport = mapOf(
        "testUserLogin" to "Passed",
        "testCheckoutProcess" to "Failed",
        "testPasswordReset" to "Passed",
        "testProfileUpdate" to "Skipped",
        "testAddProductToCart" to "Passed"
    )

    testReport.filterValues { it != "Skipped" } //возвращает новый отфильтрованный словарь, из которого исключены все пропущенные тесты.
    println(testReport)

//20. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val testEnvironmentConfig = mapOf(
        "environment" to "qa",
        "baseUrl" to "https://qa.app.internal",
        "browser" to "firefox",
        "timeoutSeconds" to "15",
        "retryAttempts" to "2"
    )
    val redusedTestEnvironmentConfig = testEnvironmentConfig - listOf ("timeoutSeconds", "retryAttempts")
//21. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val testResults21 = mapOf(
        "TC_AUTH_01" to "Passed",
        "TC_AUTH_02" to "Failed",
        "TC_PAY_01" to "Passed",
        "TC_CART_01" to "Skipped",
        "TC_SETTINGS_01" to "Passed"
    )
    val report = testResults21.map{ (key, value) -> println("$key : $value")}
println(report)
//22. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val testReport22 = mutableMapOf(
        "testUserLogin" to "Passed",
        "testCheckoutProcess" to "Failed",
        "testPasswordReset" to "Passed",
        "testProfileUpdate" to "Skipped",
        "testAddProductToCart" to "Passed"
    )
    val archiveReport = testReport22.toMap()
//23. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
//24. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
//25. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val compilationErrors = mapOf(
        "LoginTest.kt" to "Unresolved reference: authService",
        "PaymentTest.kt" to "Type mismatch: inferred type is String but Int was expected",
        "CheckoutTest.kt" to "Val cannot be reassigned",
        "ProfileTest.kt" to "Function declaration must have a body"
    )
    val result25 = compilationErrors.isEmpty()
    println(result25)

    }









//26. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
//27. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
//28. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
//29. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.