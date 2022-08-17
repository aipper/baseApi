package com.ab.mj.mjserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class CustomConfig {

    @Bean
    fun passwordEncode(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(10)
    }
}