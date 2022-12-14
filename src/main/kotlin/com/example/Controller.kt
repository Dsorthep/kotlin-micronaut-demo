package com.example

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.io.File


@Controller("/hello")
class HelloController {

    @Get()
    @Produces(MediaType.TEXT_PLAIN)
    fun index() : String {
        return "Hello World"
    }


}

@Controller("/guest")
class GuestController {
    @Get()
    fun getGuests() {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Guests.json").readText(Charsets.UTF_8)
        val jsonTextList:List<Guest> = mapper.readValue(jsonString)
        for (guest in jsonTextList) {

            println(guest)
        }
    }

    @Get("/{id}")
    fun getGuestById(id: Int): String? {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Guests.json").readText(Charsets.UTF_8)
        val jsonTextList: List<Guest> = mapper.readValue(jsonString)

        val guest = jsonTextList.find { it.id == id }


        return guest?.firstName


    }

    @Get("/{id}/room")
    fun getRoomNumberById(id: Int): Int? {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Guests.json").readText(Charsets.UTF_8)
        val jsonTextList: List<Guest> = mapper.readValue(jsonString)

        val guest = jsonTextList.find { it.id == id }


        return guest?.reservation?.roomNumber


    }


}

@Controller("/company")
class CompanyController {

    @Get()
    fun getCompanies() {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Companies.json").readText(Charsets.UTF_8)
        val jsonTextList:List<Company> = mapper.readValue(jsonString)
        for (company in jsonTextList) {
            println(company)
        }
    }

    @Get("/{id}")
    fun getCompanyById(id: Int): String? {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Companies.json").readText(Charsets.UTF_8)
        val jsonTextList:List<Company> = mapper.readValue(jsonString)

        val company = jsonTextList.find { it.id == id }

        return company?.company

    }


}

@Controller("/template")
class TemplateController {

    @Get("/{id}")
    fun getTemplateById(id: Int): String? {

        val mapper = jacksonObjectMapper()

        val jsonString: String = File("./src/main/assets/Templates.json").readText(Charsets.UTF_8)
        val jsonTextList:List<Template> = mapper.readValue(jsonString)

        val template = jsonTextList.find { it.id == id }

        return template?.text

    }

}