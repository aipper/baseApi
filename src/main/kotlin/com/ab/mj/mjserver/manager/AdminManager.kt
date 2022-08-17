package com.ab.mj.mjserver.manager

import com.ab.mj.mjserver.dto.AdminLoginDto
import com.ab.mj.mjserver.dto.UpdatePasswordDto
import com.ab.mj.mjserver.entity.MjAdmin
import com.ab.mj.mjserver.enums.ErrMsgEnums
import com.ab.mj.mjserver.handler.BizException
import com.ab.mj.mjserver.repo.AdminRepo
import com.ab.mj.mjserver.vo.BaseUserVo
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import javax.annotation.Resource
import javax.servlet.http.HttpSession

@Component
class AdminManager {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Resource
    private lateinit var coachRepo: CoachRepo

    @Resource
    private lateinit var session: HttpSession

    @Resource
    private lateinit var adminRepo: AdminRepo

    @Resource
    private lateinit var passwordEncoder: BCryptPasswordEncoder

    fun login(dto: AdminLoginDto): BaseUserVo {
        val _password = dto.password.trim()
        val admin = adminRepo.findByUsername(dto.username.trim()) ?: throw BizException(ErrMsgEnums.USER_NOT_FOUND.desc)
        if (!passwordEncoder.matches(_password, admin.password)) {
            throw BizException(ErrMsgEnums.PASSWD_ERR.desc)
        }
        val baseUser = BaseUserVo(id = admin.id, password = _password)
        session.setAttribute(session.id, baseUser)
        return baseUser
    }

    fun initAdmin() {
        val admin = MjAdmin(username = "admin", password = passwordEncoder.encode("123456"))
        val exist = adminRepo.findByUsername(admin.username)
        if (exist == null) {
            adminRepo.save(admin)
        }
    }

    fun updatePassword(user: BaseUserVo, dto: UpdatePasswordDto) {
        if (dto.oldPassword != user.password) {
            throw BizException(ErrMsgEnums.OLD_PASSWORD_ERR.desc)
        }
        adminRepo.updatePassword(user.id, passwordEncoder.encode(dto.newPassword.trim()))
    }



}