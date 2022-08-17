package com.ab.mj.mjserver.handler

import com.ab.wx.wx_lib.const.R
import com.ab.wx.wx_lib.fn.fail
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    private val logger = LoggerFactory.getLogger(ExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun handler(e: Exception): R {
        logger.error("exception:", e)
        return when (e) {
            is BizException -> fail(msg = e.msg)
            is CustomAuthException -> fail(code = 401, msg = "未授权,请登陆")
            else -> fail(msg = "${e.message}")
        }
    }
}