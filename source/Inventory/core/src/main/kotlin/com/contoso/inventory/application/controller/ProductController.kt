package com.contoso.inventory.application.controller


import com.contoso.inventory.FeedDto
import com.contoso.inventory.ProductDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@Tag(name = "Product", description = "상품 관련 API")
@RestController
class ProductController {
    @Operation(summary = "상품 목록 조회 API")
    @GetMapping("/products")
    fun findAll(): FeedDto<ProductDto> {
        return FeedDto(
            items = ProductDto.getExamples(),
            continuationToken = UUID.randomUUID().toString(),
        )
    }
}
