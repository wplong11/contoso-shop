package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "통화")
data class CurrencyDto(
    @Schema(description = "부호")
    val symbol: String,

    @Schema(description = "ISO 4217 코드")
    val code: String,
) {
    companion object {
        fun getExamples(): List<CurrencyDto> = listOf(
            CurrencyDto(
                symbol = "₩",
                code = "KRW",
            ),
            CurrencyDto(
                symbol = "$",
                code = "USD",
            ),
        )
    }
}
