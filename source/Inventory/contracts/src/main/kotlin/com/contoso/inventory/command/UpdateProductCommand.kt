package com.contoso.inventory.command

import com.contoso.inventory.PriceDto
import com.contoso.inventory.ProductContentDto
import com.contoso.inventory.ProductId

data class UpdateProductCommand(
    val productId: ProductId,
    val content: ProductContentDto,
    val sellingPrice: PriceDto,
) {
    companion object {
        fun getExamples(): List<UpdateProductCommand> = listOf(
            UpdateProductCommand(
                productId = ProductId.randomUUID(),
                content = ProductContentDto.getExamples().random(),
                sellingPrice = PriceDto.getExamples().random(),
            ),
        )
    }
}
