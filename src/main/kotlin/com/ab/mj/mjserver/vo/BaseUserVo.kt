package com.ab.mj.mjserver.vo

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable

data class BaseUserVo(
    val id: Int = 0,
    val openid: String = "",
    @JsonIgnore
    val password: String = ""
) : Serializable
