package com.ab.mj.mjserver.entity

import javax.persistence.*

@Entity
@Table(name = "mj_admin")
data class MjAdmin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val username: String = "",
    val password: String = ""
)
