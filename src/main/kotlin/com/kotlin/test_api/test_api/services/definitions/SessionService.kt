package com.kotlin.test_api.test_api.services.definitions

import com.kotlin.test_api.test_api.dto.SessionDTO

interface SessionService {
    fun findAll() : MutableList<SessionDTO>
    fun findById(id: Long) : SessionDTO?
    fun create(sessionDTO : SessionDTO) : SessionDTO
    fun update(sessionDTO : SessionDTO, id: Long) : SessionDTO?
    fun delete(id: Long) : String?
}