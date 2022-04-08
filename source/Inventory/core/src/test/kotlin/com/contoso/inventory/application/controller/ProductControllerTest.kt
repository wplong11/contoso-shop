package com.contoso.inventory.application.controller

import com.contoso.inventory.FeedDto
import com.contoso.inventory.ProductDto
import com.contoso.inventory.command.UpdateProductCommand
import com.contoso.inventory.defaultObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
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

    @Test
    fun `sut executes UpdateProductCommand correctly`() {
        // Act
        val content = UpdateProductCommand.getExamples().random()
        val response = mockMvc.perform(
            post("/products/execute/update-product-command")
                .content(defaultObjectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )

        // Assert
        response.andExpect(status().isOk)
    }
}
