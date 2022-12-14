package com.example
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull

//@MicronautTest
//class KotlinMicronautDemoTest {
//
//    @Inject
//    lateinit var application: EmbeddedApplication<*>
//
//    @Test
//    fun testItWorks() {
//        Assertions.assertTrue(application.isRunning)
//    }
//
//}

@MicronautTest
class HelloControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client : HttpClient

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("Hello World", body)
    }
}
