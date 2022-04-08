package com.contoso.inventory.command

import com.contoso.inventory.*

data class RequestForCreatingProductCommand(
    val requestId: RequestForApprovalId,
    val productId: ProductId,
    val content: ProductContentDto,
    val sellingPrice: PriceDto,
) {
    companion object {
        fun getExamples(): List<RequestForCreatingProductCommand> = listOf(
            RequestForCreatingProductCommand(
                requestId = RequestForApprovalId.randomUUID(),
                productId = ProductId.randomUUID(),
                content = ProductContentDto.getExamples().random(),
                sellingPrice = PriceDto.getExamples().random(),
            ),
        )
    }
}
