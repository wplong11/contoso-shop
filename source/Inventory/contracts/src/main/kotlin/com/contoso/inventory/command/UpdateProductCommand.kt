package com.contoso.inventory.command

import com.contoso.inventory.FeeDto
import com.contoso.inventory.PriceDto
import com.contoso.inventory.ProductContentDto
import com.contoso.inventory.ProductId

data class UpdateProductCommand(
    val productId: ProductId,
    val contents: Map<String, ProductContentDto>,
    val sellingPrice: PriceDto,
    val fee: FeeDto,
) {
    companion object {
        fun getExamples(): List<UpdateProductCommand> = listOf(
            UpdateProductCommand(
                productId = ProductId.randomUUID(),
                contents = mapOf(
                    "en" to ProductContentDto.getExamples().random(),
                    "jp" to ProductContentDto.getExamples().random(),
                ),
                sellingPrice = PriceDto.getExamples().random(),
                fee = FeeDto.getExamples().random(),
            ),
        )
    }
}
