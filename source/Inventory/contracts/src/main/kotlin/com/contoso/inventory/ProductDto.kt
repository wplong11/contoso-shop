package com.contoso.inventory

data class ProductDto(
    val id: ProductId,
    val content: ProductContentDto,
    val sellingPrice: PriceDto,
    val fee: FeeDto,
) {
    companion object {
        fun getExamples(): List<ProductDto> = listOf(
            ProductDto(
                id = ProductId.randomUUID(),
                content = ProductContentDto.getExamples().random(),
                sellingPrice = PriceDto.getExamples().random(),
                fee = FeeDto.getExamples().random(),
            ),
        )
    }
}
