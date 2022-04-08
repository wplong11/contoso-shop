package com.contoso.inventory.application.controller


import com.contoso.inventory.FeedDto
import com.contoso.inventory.ProductDto
import com.contoso.inventory.command.UpdateProductCommand
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @Operation(summary = "상품 수정 API")
    @PostMapping("/products/execute/update-product-command")
    fun updateProductCommand(
        @RequestBody command: UpdateProductCommand
    ): Unit = Unit
}
