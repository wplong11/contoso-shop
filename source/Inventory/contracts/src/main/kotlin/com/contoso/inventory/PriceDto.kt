package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "가격")
data class PriceDto(
    val currency: CurrencyDto,
    val value: Long,
) {
    companion object {
        fun getExamples(): List<PriceDto> = CurrencyDto.getExamples().map {
            PriceDto(
                currency = it,
                value = (1_000L..5_000L).random(),
            )
        }
    }
}
