package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "수수료 종류")
enum class FeeKind {
    @Schema(description = "총액")
    amount,

    @Schema(description = "만분율")
    basisPoint,
}
