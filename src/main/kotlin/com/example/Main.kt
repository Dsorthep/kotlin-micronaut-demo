package com.example

import java.util.*

fun main() {

    println(templateOne())
    println(templateTwo())
    println(templateThree())

}

data class Guest(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val reservation: Reservation
)

data class Reservation(
    val roomNumber: Int,
    val startTimestamp: Int,
    val endTimestamp: Int
)

data class Company(
    val id: Int,
    val company: String,
    val city: String,
    val timezone: String,
)

data class Template(
    val id: Int,
    val title: String,
    val text: String,
)

fun getGreeting(): String {
    val calendar = Calendar.getInstance()

    return when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 0..11 -> "Good Morning,"
        in 12..15 -> "Good Afternoon,"
        in 16..20 -> "Good Evening,"
        in 21..24 -> "Good Night,"
        else -> "Hello"
    }

}

data class GuestMessage(
    val greeting: String = getGreeting(),
    val name: String? = GuestController().getGuestById(2),
    val company: String? = CompanyController().getCompanyById(2),
    val roomNumber: Int? = GuestController().getRoomNumberById(2),
    val template: String? = TemplateController().getTemplateById(2),
)

fun templateOne(): String {

    val guest = GuestMessage()

    val greeting = guest.greeting
    val name = guest.name
    val company = guest.company
    val roomNumber = guest.roomNumber
    val template = guest.template

    return "$greeting $name, and welcome to $company! Room $roomNumber is now ready for you. Enjoy your stay, and let us know if you need anything."

}

fun templateTwo(): String {

    val guest = GuestMessage()

    val greeting = guest.greeting
    val name = guest.name
    val company = guest.company
    val roomNumber = guest.roomNumber
    val template = guest.template

    return "$greeting $name! Thanks for staying at $company. We have you in room $roomNumber and please let us know if you need anything else. We hope you enjoy your stay!"

}

fun templateThree(): String {

    val guest = GuestMessage()

    val greeting = guest.greeting
    val name = guest.name
    val company = guest.company
    val roomNumber = guest.roomNumber
    val template = guest.template


    return "$greeting $name! The team from $company welcomes you to our facility. You'll be staying in room $roomNumber. Please let us know if we can make your stay better. Enjoy your stay!"

}


