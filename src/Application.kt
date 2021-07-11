package com.pertemuan12.Agus18104002

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }

        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        get("/") {
            call.respondText("HELLO SE STUDENT!", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/student") {
            val students = listOf(Student(nim = 123456,nama = "Steve Roger",prodi = "Rekayasa Perangkat Lunak"),Student(nim = 123457,nama = "TonyStark",prodi = "Rekayasa Perangkat Lunak"))

            call.respond(mapOf("error" to false,"message" to "success","data" to students))
        }

        get("/smartphone") {
            val smartphones = listOf(
                Smartphone("Xiaomi", "4 GB", "7 Inch", "62 GB", 2300000),
                Smartphone("Poco", "8 GB", "5 Inch", "128 GB", 4300000),
                Smartphone("Realmi", "6 GB", "6 Inch", "256 GB", 3300000),
                Smartphone("Vivo", "2 GB", "7 Inch", "32 GB", 2500000),
                Smartphone("Samsung", "8 GB", "6 Inch", "64 GB", 2100000),
                Smartphone("Polytron", "8 GB", "6 Inch", "32 GB", 2900000),
                Smartphone("Oppo", "4 GB", "4 Inch", "32 GB", 2700000),
                Smartphone("Apple", "2 GB", "4 Inch", "32 GB", 2300000),
                Smartphone("Huawei", "8 GB", "6 Inch", "64 GB", 2900000),
                Smartphone("Xiaomi", "4 GB", "7 Inch", "64 GB", 2000000),
            )

            call.respond(mapOf("error" to false,"message" to "success","data" to smartphones))
        }
    }
}

data class Student(val nim : Int,val nama : String,val prodi : String)
data class Smartphone(val merk : String,val ram : String,val screen : String, val storage: String, val price: Int)