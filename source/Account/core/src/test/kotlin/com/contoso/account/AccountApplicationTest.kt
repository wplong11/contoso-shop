package com.contoso.account

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class AccountApplicationTest {
    @Test
    fun contextLoads() {
    }
}
