package com.contoso.inventory.application.controller

import com.contoso.inventory.FeedDto
import com.contoso.inventory.ProductDto
import com.contoso.inventory.defaultObjectMapper
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

@WebMvcTest(controllers = [ProductController::class])
class ProductControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    @Test
    fun `sut returns correctly`() {
        // Act
        val response = mockMvc.perform(
            get("/products")
        )

        // Assert
        response.andExpect(status().isOk)
        val responseText: String = response.andReturn().response.contentAsString
        val actual: FeedDto<ProductDto> = defaultObjectMapper.readValue(responseText)
        assertThat(actual.items).isNotEmpty
    }
}
