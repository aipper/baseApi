package com.ab.mj.mjserver.api

import com.ab.wx.wx_lib.const.R
import com.ab.wx.wx_lib.const.WxConst
import com.ab.wx.wx_lib.fn.ok
import com.ab.wx.wx_lib.fn.sha1
import com.ab.wx.wx_lib.wx.Wx
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource

@RestController
@RequestMapping("wx")
class WxApi {
    private val logger = LoggerFactory.getLogger(WxApi::class.java)

    @Resource
    private lateinit var wx: Wx

    @GetMapping("check")
    fun check(signature: String, timestamp: String, nonce: String, echostr: String): String {
        val res = wx.check(signature, timestamp, nonce, echostr)
        logger.info("res:$res")
        return res
    }


}