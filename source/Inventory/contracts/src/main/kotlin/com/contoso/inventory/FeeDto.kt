package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "수수료")
data class FeeDto(
    val kind: FeeKind,
    val amount: PriceDto?,
    val basisPoint: Int?,
) {
    companion object {
        fun getExamples(): List<FeeDto> = listOf(
            FeeDto(
                kind = FeeKind.amount,
                amount = PriceDto.getExamples().random(),
                basisPoint = null,
            ),
            FeeDto(
                kind = FeeKind.basisPoint,
                amount = null,
                basisPoint = (100..10_000).random(),
            ),
        )
    }
}

