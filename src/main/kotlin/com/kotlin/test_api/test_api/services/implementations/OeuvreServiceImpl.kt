package com.kotlin.test_api.test_api.services.implementations

import com.kotlin.test_api.test_api.dto.OeuvreDTO
import com.kotlin.test_api.test_api.mappers.EntityMapper.dtoToOeuvre
import com.kotlin.test_api.test_api.mappers.EntityMapper.oeuvreToDto
import com.kotlin.test_api.test_api.repositories.OeuvreRepository
import com.kotlin.test_api.test_api.services.definitions.OeuvreService
import org.springframework.stereotype.Service

@Service
class OeuvreServiceImpl (
    oeuvreRepository: OeuvreRepository
        )
    : OeuvreService {

    private val oeuvreRepository: OeuvreRepository

    init {
        this.oeuvreRepository = oeuvreRepository
    }


    override fun findAll(): MutableList<OeuvreDTO> {
        val oeuvres = this.oeuvreRepository.findAll()
        return oeuvres.stream().map { oeuvre -> oeuvreToDto(oeuvre) }.toList()
    }

    override fun findById(id: Long): OeuvreDTO? {
        val oeuvre = this.oeuvreRepository.findById(id).orElse(null)
        if(oeuvre != null){
            return oeuvreToDto(oeuvre)
        }
        return null
    }

    override fun create(oeuvreDTO: OeuvreDTO): OeuvreDTO {
        val oeuvre = this.oeuvreRepository.save(dtoToOeuvre(oeuvreDTO))
        return oeuvreToDto(oeuvre)
    }

    override fun update(oeuvreDTO: OeuvreDTO, id: Long): OeuvreDTO? {
        val oeuvreFounded = this.oeuvreRepository.findById(id).orElse(null)
        if(oeuvreFounded != null){
          oeuvreFounded.titre = oeuvreDTO.titre
          oeuvreFounded.dateCreation = oeuvreDTO.dateCreation
          oeuvreFounded.prix = oeuvreDTO.prix
          oeuvreFounded.annee = oeuvreDTO.annee
          oeuvreFounded.rating = oeuvreDTO.rating
          oeuvreFounded.type = oeuvreDTO.type
          oeuvreFounded.image = oeuvreDTO.image
            return oeuvreToDto(oeuvreFounded)
        }
        return null
    }

    override fun delete(id: Long): String? {
        val oeuvre = this.oeuvreRepository.findById(id).orElse(null)
        if(oeuvre != null){
            this.oeuvreRepository.delete(oeuvre)
            return "Suppression effectuée avec succès"
        }
        return null
    }
}