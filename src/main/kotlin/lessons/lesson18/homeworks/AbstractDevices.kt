package org.example.lessons.lesson18.homeworks

//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//
//Холодильник
//Стиральная машина
//Умная лампа
//Электронные часы
//Робот-пылесос
//Механические часы
//Фонарик
//Кофемашина
//Умная колонка
//abstract class Fridge (
//    val brand: String,
//    val serialNumber: String,
//    val noFrost: Boolean,
//    override val maxTemperature: Int
//): Powerable, Openable , TemperatureRegulatable {
//}
//abstract class WashMachine (
//    val brand: String,
//    val serialNumber: String,
//    override val maxTemperature: Int
//): Powerable, Programmable, Openable, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Drainable, Timable {

//}
abstract class SmartLamp():
        Powerable, Timable, LightEmitting, SoundEmitting, Programmable {}
abstract class ElectronicWages ():
        Powerable, SoundEmitting, BatteryOperated{}
abstract class RobotHoover ():
        Powerable, Timable, SoundEmitting, Programmable, Movable, Cleanable {}
abstract class MechanicalWatches (): Mechanical {}
abstract class FlashLight():
        Powerable, LightEmitting, BatteryOperated {}
abstract class CoffeMaker():
        Powerable, Programmable, SoundEmitting, Cleanable {}
abstract class SmartSpeaker: Powerable, SoundEmitting, Programmable, Timable {}

