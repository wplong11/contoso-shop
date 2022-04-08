package com.contoso.inventory.command

import com.contoso.inventory.PriceDto
import com.contoso.inventory.ProductContentDto
import com.contoso.inventory.ProductId
import com.contoso.inventory.RequestForApprovalId

data class RequestForUpdatingProductCommand(
    val requestId: RequestForApprovalId,
    val productId: ProductId,
    val content: ProductContentDto,
    val sellingPrice: PriceDto,
) {
    companion object {
        fun getExamples(): List<RequestForUpdatingProductCommand> = listOf(
            RequestForUpdatingProductCommand(
                requestId = RequestForApprovalId.randomUUID(),
                productId = ProductId.randomUUID(),
                content = ProductContentDto.getExamples().random(),
                sellingPrice = PriceDto.getExamples().random(),
            ),
        )
    }
}

