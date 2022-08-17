package com.ab.mj.mjserver.dto

import java.io.Serializable

data class UpdatePasswordDto(
    val oldPassword: String = "",
    val newPassword: String = ""
) : Serializable
