package com.ab.mj.mjserver.api

import com.ab.wx.wx_lib.const.R
import com.ab.wx.wx_lib.fn.ok
import com.ab.wx.wx_lib.wx.MiniApp
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("miniapp")
class MiniAppApi {
    private val logger = LoggerFactory.getLogger(MiniAppApi::class.java)

    @Resource
    private lateinit var miniApp: MiniApp

    @GetMapping("code2session")
    fun code2session(@RequestParam code: String): R {
        val res = miniApp.getCode2Session(code)
        logger.info("res:$res")
        return ok(data = res)
    }

}