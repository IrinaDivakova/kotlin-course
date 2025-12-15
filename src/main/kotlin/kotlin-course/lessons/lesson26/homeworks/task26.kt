package org.example.`kotlin-course`.lessons.lesson26.homeworks
import java.io.File

fun main() {
    //Задача 1
//
    val file1 = File("workspace/task1/example.txt").apply {
        parentFile.mkdirs() // метод, который гарантирует, что эта родительская папка (task1) и все необходимые вышестоящие папки (workspace) будут созданы, если они еще не существуют
        writeText("Hello, Kotlin!")
    }.exists() // <-- Возвращает булево значение: существует ли файл

    println("Проверка существования файла: $file1")
ex7()
ex8()
//Создайте текстовый файл workspace/task1/example.txt.
// Запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.
// Реши задачу с использованием scope функции без создания переменной.
//
//Задача 2
//Создайте директорию workspace/task2/testDir.
// Проверьте, является ли она директорией, и выведите её абсолютный путь.
//
    val ex2 = File("workspace/task2/testDir.").apply {
        parentFile.mkdirs()
        mkdirs()
        if (isDirectory) {
            println("Great, u did it")
        } else {
            println("Looser!")
        }
        println(absolutePath)
    }
//Задача 3
    val ex3 = {
        with(File("workspace/task3/structure.")) {
            parentFile.mkdirs()
            mkdirs()
            resolve("myDir") // resolve() — это как ручка; он записывает путь, но не строит здание по этому адресу
        }.apply {
            mkdirs()// created dir
            resolve("subDir1").mkdir()
            resolve("subDir2").mkdir()
            val contents = list()
            if (contents.contains("subDir1") && contents.contains("subDir2")) {
                println("Great! You did 3ex.myDir сontains subDir1 и subDir2.")
            } else {
                println("Let`s cry. myDir contains [$contents]")
            }
        }
    }
    ex3()

//Создайте директорию workspace/task3/structure.
// Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir2.
// Проверьте, что myDir действительно содержит эти поддиректории.
// Используй scope функции для минимизации создания переменных
// а так же метод file.resolve("myDir") для создания нового объекта File путём добавления к существующему пути
// ещё одной секции. И так же для других директорий.
//
//Задача 4
//
//Создайте директорию workspace/task4/temp.
// Внутри директории temp создайте несколько вложенных файлов и директорий.
// Удалите директорию workspace/task4 со всем содержимым
//
fun ex4() {
        with(File("workspace/task4/temp.")) {
            parentFile.mkdirs()
            mkdirs()
            resolve("New folder")
        }.apply {
            mkdirs()
            resolve("abc").mkdir()
            resolve("fgh").mkdir()
            resolve("tyui").mkdir()
            val condition = list()
            if(condition.contains("gold")) {
                parentFile.deleteRecursively()
            } else {
println("The directory wasn`t deleted")
            }
        }
    }
ex5()
    ex6()
}
//Задача 5
//
//Создайте файл workspace/task5/config/config.txt.
// запишите в него список параметров (в формате ключ=значение),
// а затем прочитайте файл и выведите только значения.
//
fun ex5() {
    with(File("workspace/task5/config/config.txt")) { // with для работы с этим файлом
        parentFile.mkdirs() //род папка
        createNewFile()  // file itself
        listOf("1 = АААААААААА", "2 = плачуу", "3 = очень громкооооооо").also {
            writeText(it.joinToString("\n")) // writeText принимает только 1 стр, so need tostring
        }//гарантируете, что каждая исходная строка (например, 1 = ААА) будет записана в файл на своей отдельной строке.
        readLines().map { // вернет список из трех элементов, then mapping
            it.split("=")
                .getOrNull(1)
                ?.trim() ?: ""
        }.also {
            println(it.joinToString())
        }
    }
  }

//Задача 6
//
//Пройди по всем вложенным директориям workspace
fun ex6() {
    File("workspace").apply {
        walk().groupBy { if (it.isDirectory) "dir" else "file" }
            .also {
                println("Directories")
                println(it["dir"]?.joinToString("\n"))
                println("Files")
                println(it["file"]?.joinToString("\n"))
            }
    }
}
// и выведи в консоль сначала пути директорий, а потом пути файлов
//
//Задача 7
//
//Создайте директорию workspace/task7/docs.
fun ex7() {
    val a = "This is a README file."

    File("workspace/task7/docs.").apply {
        parentFile?.mkdirs()
if (File("readme.md.").exists())
{
    println(" the file exists")
    } else {
        createNewFile()
    writeText(a) }
check(readText() == a){"no sch file"}
    }
}
// Проверь, есть ли файл с именем readme.md.
// Если файла нет, создайте его и запишите текст "This is a README file.".
// Проверьте текст в файле.
//
//Задача 8
//
//Создайте файлы
//
//workspace/task8/data/1/4/prod/data14.mysql
//workspace/task8/data/2/3/prod/data23.mysql
//workspace/task8/data/5/2/prod/data52.mysql
//Создайте директорию workspace/task8/backup
fun ex8() {
    File("workspace/task8").deleteRecursively()
    listOf(
        "workspace/task8/data/1/4/prod/data14.mysql",
        "workspace/task8/data/2/3/prod/data23.mysql",
        "workspace/task8/data/5/2/prod/data52.mysql",
    ).forEach {
        File(it).apply {
            parentFile?.mkdirs()
        }.createNewFile()
    }
    val backup = File("workspace/task8/backup").also { it.mkdirs() }
    File("workspace/task8/data").apply {
        walk().filter { it.isFile }
            .forEach {
                val relative = it.relativeTo(this)
                it.copyTo(backup.resolve(relative))
            }
    }
}
// и скопируйте туда файлы из workspace/task8/data сохраняя структуру директорий.
// Для копирования используй метод copyTo.
// Для получения относительного пути начиная от data используй relativeTo от пути до файла,
// передавая в него путь до базовой директории (то-есть data).
// Полученный relative фрагмент можно присоединить к пути бэкапа через resolve и
// таким образом получить путь назначения копирования, например workspace/task8/backup/1/4/prod/data14.mysql сохраняя весь относительный путь.