package com.kotlin.test_api.test_api.services.definitions

import com.kotlin.test_api.test_api.dto.OeuvreDTO

interface OeuvreService {
    fun findAll() : MutableList<OeuvreDTO>
    fun findById(id: Long) : OeuvreDTO?
    fun create(oeuvreDTO : OeuvreDTO) : OeuvreDTO
    fun update(oeuvreDTO : OeuvreDTO, id: Long) : OeuvreDTO?
    fun delete(id: Long) : String?
}