package org.example.`kotlin-course`.lessons.lesson18.homeworks
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

abstract class Fridge: Powerable, Openable, TemperatureRegulatable, SoundEmitting, Timable, Programmable  {
}
abstract class WashingMachine: Powerable, Openable, TemperatureRegulatable, SoundEmitting, Timable, Programmable, WaterContainer, WaterConnection,AutomaticShutdown, Drainable, LightEmitting {}
abstract class SmartLamp: Powerable, SoundEmitting, LightEmitting, Timable, Programmable, BatteryOperated, Rechargeable
abstract class ElectronicWatch: Powerable, SoundEmitting, LightEmitting, Timable, Programmable, BatteryOperated, Rechargeable
abstract class RobotVacuum: Powerable, SoundEmitting, LightEmitting, Timable, Programmable, BatteryOperated, Rechargeable, Movable,  Cleanable
abstract class MechanicalClock : Mechanical, Timable
abstract class Flashlight : Powerable, LightEmitting, BatteryOperated, Rechargeable
abstract class CoffeeMachine : Powerable, WaterContainer, Timable, Programmable, TemperatureRegulatable, Drainable, SoundEmitting, LightEmitting
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable, WaterConnection