package com.contoso.inventory.application.controller

import com.contoso.inventory.command.RequestForCreatingProductCommand
import com.contoso.inventory.defaultObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [RequestForApprovalController::class])
class RequestForApprovalControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    @Test
    fun `sut executes RequestForCreatingProductCommand correctly`() {
        // Act
        val content = RequestForCreatingProductCommand.getExamples().random()
        val response = mockMvc.perform(
            post("/request-for-approval/execute/request-for-creating-product-command")
                .content(defaultObjectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )

        // Assert
        response.andExpect(status().isOk)
    }
}
