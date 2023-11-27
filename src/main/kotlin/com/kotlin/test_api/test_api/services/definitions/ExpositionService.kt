package com.kotlin.test_api.test_api.services.definitions

import com.kotlin.test_api.test_api.dto.ExpositionDTO

interface ExpositionService {
    fun findAll() : MutableList<ExpositionDTO>
    fun findById(id: Long) : ExpositionDTO?
    fun create(expositionDTO : ExpositionDTO) : ExpositionDTO
    fun update(expositionDTO : ExpositionDTO, id: Long) : ExpositionDTO?
    fun delete(id: Long) : String?
}