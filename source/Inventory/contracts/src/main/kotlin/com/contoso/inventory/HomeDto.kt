package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "HomeDto 입니다")
data class HomeDto(
    @Schema(description = "메세지 내용 입니다")
    val message: String,
)
