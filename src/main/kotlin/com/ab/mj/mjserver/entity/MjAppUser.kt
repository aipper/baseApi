package com.ab.mj.mjserver.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "mj_appuser")
data class MjAppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val username: String = "",
    val mobile: String = "",
    val openid: String = "",
    @CreatedDate
    val createTime: LocalDateTime = LocalDateTime.now()

)