package com.contoso.inventory.command

import com.contoso.inventory.FeeDto
import com.contoso.inventory.ProductContentDto
import com.contoso.inventory.RequestForApprovalId

data class ApproveRequestForUpdatingProductCommand(
    val requestId: RequestForApprovalId,
    val contents: Map<String, ProductContentDto>,
    val fee: FeeDto,
) {
    companion object {
        fun getExamples(): List<ApproveRequestForUpdatingProductCommand> = listOf(
            ApproveRequestForUpdatingProductCommand(
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
