package com.contoso.inventory

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "패키지 콘텐츠")
data class ProductContentDto(
    @Schema(description = "제목")
    val title: String,

    @Schema(description = "내용")
    val description: String,
) {
    companion object {
        fun getExamples(): List<ProductContentDto> = listOf(
            ProductContentDto(
                title = "제목입니다",
                description = "내용입니다",
            ),
        )
    }
}

