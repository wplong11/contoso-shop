package com.contoso.inventory.application.controller

import com.contoso.inventory.FeedDto
import com.contoso.inventory.RequestForApprovalDto
import com.contoso.inventory.command.ApproveRequestForCreatingProductCommand
import com.contoso.inventory.command.ApproveRequestForUpdatingProductCommand
import com.contoso.inventory.command.RequestForCreatingProductCommand
import com.contoso.inventory.command.RequestForUpdatingProductCommand
import com.contoso.inventory.defaultObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [RequestForApprovalController::class])
class RequestForApprovalControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {
    @Test
    fun `sut returns feed correctly`() {
        // Act
        val response = mockMvc.perform(
            MockMvcRequestBuilders.get("/request-for-approval")
        )

        // Assert
        response.andExpect(status().isOk)
        val responseText: String = response.andReturn().response.contentAsString
        val actual: FeedDto<RequestForApprovalDto> = defaultObjectMapper.readValue(responseText)
        Assertions.assertThat(actual.items).isNotEmpty
    }

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

    @Test
    fun `sut executes RequestForUpdatingProductCommand correctly`() {
        // Act
        val content = RequestForUpdatingProductCommand.getExamples().random()
        val response = mockMvc.perform(
            post("/request-for-approval/execute/request-for-updating-product-command")
                .content(defaultObjectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )

        // Assert
        response.andExpect(status().isOk)
    }

    @Test
    fun `sut executes ApproveRequestForCreatingProductCommand correctly`() {
        // Act
        val content = ApproveRequestForCreatingProductCommand.getExamples().random()
        val response = mockMvc.perform(
            post("/request-for-approval/execute/approve-request-for-creating-product-command")
                .content(defaultObjectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )

        // Assert
        response.andExpect(status().isOk)
    }

    @Test
    fun `sut executes ApproveRequestForUpdatingProductCommand correctly`() {
        // Act
        val content = ApproveRequestForUpdatingProductCommand.getExamples().random()
        val response = mockMvc.perform(
            post("/request-for-approval/execute/approve-request-for-updating-product-command")
                .content(defaultObjectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )

        // Assert
        response.andExpect(status().isOk)
    }
}
