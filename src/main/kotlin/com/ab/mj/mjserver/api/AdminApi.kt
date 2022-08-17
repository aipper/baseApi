package com.ab.mj.mjserver.api

import com.ab.mj.mjserver.anno.CurrentUser
import com.ab.mj.mjserver.dto.AdminLoginDto
import com.ab.mj.mjserver.dto.UpdatePasswordDto
import com.ab.mj.mjserver.manager.AdminManager
import com.ab.mj.mjserver.vo.BaseUserVo
import com.ab.wx.wx_lib.const.R
import com.ab.wx.wx_lib.fn.ok
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct
import javax.annotation.Resource

@RestController
@RequestMapping("admin")
class AdminApi {

    @Resource
    private lateinit var manager: AdminManager

    @PostConstruct
    fun initAdmin() {
        manager.initAdmin()
    }

    @PostMapping("login")
    fun login(@RequestBody dto: AdminLoginDto): R {
        return ok(data = manager.login(dto))
    }

    @PostMapping("updatePassword")
    fun updatePassword(@CurrentUser user: BaseUserVo, @RequestBody dto: UpdatePasswordDto): R {
        manager.updatePassword(user, dto)
        return ok()
    }


}