package com.ab.mj.mjserver.repo

import com.ab.mj.mjserver.entity.MjAdmin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface AdminRepo : JpaRepository<MjAdmin, Int> {
    @Query("from MjAdmin  where username = :username")
    fun findByUsername(username: String): MjAdmin?

    @Modifying
    @Transactional
    @Query("update MjAdmin set password = ?2 where id = ?1")
    fun updatePassword(id: Int, password: String?)
}