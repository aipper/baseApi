package com.ab.mj.mjserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
    @Bean
    fun argsResolverHandler(): ArgsResolverHandler {
        return ArgsResolverHandler()
    }


    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(argsResolverHandler())
        super.addArgumentResolvers(resolvers)
    }
}