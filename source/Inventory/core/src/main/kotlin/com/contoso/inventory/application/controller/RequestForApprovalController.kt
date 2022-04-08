package com.contoso.inventory.application.controller

import com.contoso.inventory.FeedDto
import com.contoso.inventory.RequestForApprovalDto
import com.contoso.inventory.command.ApproveRequestForCreatingProductCommand
import com.contoso.inventory.command.RequestForCreatingProductCommand
import com.contoso.inventory.command.RequestForUpdatingProductCommand
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "RequestForApproval", description = "승인 요청 관련 API")
@RestController
class RequestForApprovalController {
    @Operation(summary = "승인 요청 목록 조회 API")
    @GetMapping("/request-for-approval")
    fun getFeed(continuationToken: String?): FeedDto<RequestForApprovalDto> {
        return FeedDto(
            items = RequestForApprovalDto.getExamples(),
            continuationToken = continuationToken,
        )
    }

    @Operation(summary = "Product 생성 요청 API")
    @PostMapping("/request-for-approval/execute/request-for-creating-product-command")
    fun requestForCreatingProductCommand(
        @RequestBody command: RequestForCreatingProductCommand
    ): Unit = Unit

    @Operation(summary = "Product 수정 요청 API")
    @PostMapping("/request-for-approval/execute/request-for-updating-product-command")
    fun requestForUpdatingProductCommand(
        @RequestBody command: RequestForUpdatingProductCommand
    ): Unit = Unit

    @Operation(summary = "Product 생성 요청 승인 API")
    @PostMapping("/request-for-approval/execute/approve-request-for-creating-product-command")
    fun approveRequestForCreatingProductCommand(
        @RequestBody command: ApproveRequestForCreatingProductCommand
    ): Unit = Unit
}
