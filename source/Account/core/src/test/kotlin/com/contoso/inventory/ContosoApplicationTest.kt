package com.contoso.inventory

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class ContosoApplicationTest {
    @Test
    fun contextLoads() {
    }
}
