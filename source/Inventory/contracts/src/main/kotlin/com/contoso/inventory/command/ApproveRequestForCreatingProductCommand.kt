package com.contoso.inventory.command

import com.contoso.inventory.FeeDto
import com.contoso.inventory.ProductContentDto
import com.contoso.inventory.RequestForApprovalId

data class ApproveRequestForCreatingProductCommand(
    val requestId: RequestForApprovalId,
    val contents: Map<String, ProductContentDto>,
    val fee: FeeDto,
) {
    companion object {
        fun getExamples(): List<ApproveRequestForCreatingProductCommand> = listOf(
            ApproveRequestForCreatingProductCommand(
                requestId = RequestForApprovalId.randomUUID(),
                contents = mapOf(
                    "en" to ProductContentDto.getExamples().random(),
                    "jp" to ProductContentDto.getExamples().random(),
                ),
                fee = FeeDto.getExamples().random(),
            ),
        )
    }
}

