package com.ab.mj.mjserver.enums

enum class ErrMsgEnums(val desc: String) {
    PASSWD_ERR("密码错误"),
    USER_NOT_FOUND("用户名不存在"),
    OLD_PASSWORD_ERR("旧密码不正确")
}