package com.ab.mj.mjserver.config

import com.ab.mj.mjserver.anno.CurrentUser
import com.ab.mj.mjserver.handler.CustomAuthException
import org.slf4j.LoggerFactory
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.server.ServerWebExchange
import javax.security.auth.message.AuthException

class ArgsResolverHandler : HandlerMethodArgumentResolver {
    private val logger = LoggerFactory.getLogger(ArgsResolverHandler::class.java)
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(CurrentUser::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any {
        return webRequest.getAttribute(webRequest.sessionId, NativeWebRequest.SCOPE_SESSION) ?: throw  CustomAuthException()
    }
}