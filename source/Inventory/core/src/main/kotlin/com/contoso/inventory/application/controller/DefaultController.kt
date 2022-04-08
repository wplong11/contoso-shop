package com.contoso.inventory.application.controller

import com.contoso.inventory.HomeDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Default", description = "테스트 목적")
@RestController
class DefaultController {
    @Operation(summary = "테스트 API")
    @GetMapping("/")
    fun home(): HomeDto = HomeDto(
        message = "HelloWorld",
    )
}
