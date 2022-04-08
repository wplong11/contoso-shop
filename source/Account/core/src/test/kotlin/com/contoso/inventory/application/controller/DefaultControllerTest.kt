package com.contoso.inventory.application.controller

import com.appmattus.kotlinfixture.kotlinFixture
import com.contoso.account.application.controller.DefaultController
import com.contoso.shop.HomeDto
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [DefaultController::class])
internal class DefaultControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val fixture = kotlinFixture()

    private val objectMapper =
        jacksonObjectMapper().registerModule(JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

    @Test
    fun `sut returns correctly`() {
        // Act
        val response = mockMvc.perform(
            get("/")
        )

        // Assert
        response.andExpect(status().isOk)
        val responseText: String = response.andReturn().response.contentAsString
        val actual: HomeDto = objectMapper.readValue(responseText)
        val expected = HomeDto(
            message = "HelloWorld",
        )
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected)
    }
}
