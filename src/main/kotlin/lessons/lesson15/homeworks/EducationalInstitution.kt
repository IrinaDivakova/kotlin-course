package org.example.lessons.lesson15.homeworks

open class EducationalInstitution(
    val name: String,
    val address: String
) {
    fun printInfo() {
        println("Institution: $name, address: $address")
    }
}

open class School(
    name: String,
    address: String,
    val studentsCount: Int
) : EducationalInstitution(name, address)

class PrimarySchool(
    name: String,
    address: String,
    studentsCount: Int,
    val grades: Int
) : School(name, address, studentsCount)

class HighSchool(
    name: String,
    address: String,
    studentsCount: Int,
    val specialization: String
) : School(name, address, studentsCount)

class University(
    name: String,
    address: String,
    val facultiesCount: Int
) : EducationalInstitution(name, address)