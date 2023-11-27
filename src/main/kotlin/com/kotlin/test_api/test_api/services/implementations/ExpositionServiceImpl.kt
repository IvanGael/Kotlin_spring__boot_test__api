package com.kotlin.test_api.test_api.services.implementations

import com.kotlin.test_api.test_api.dto.ExpositionDTO
import com.kotlin.test_api.test_api.mappers.EntityMapper.dtoToExposition
import com.kotlin.test_api.test_api.mappers.EntityMapper.dtoToOeuvre
import com.kotlin.test_api.test_api.mappers.EntityMapper.dtoToSession
import com.kotlin.test_api.test_api.mappers.EntityMapper.expositionToDto
import com.kotlin.test_api.test_api.mappers.EntityMapper.oeuvreToDto
import com.kotlin.test_api.test_api.mappers.EntityMapper.sessionToDto
import com.kotlin.test_api.test_api.repositories.ExpositionRepository
import com.kotlin.test_api.test_api.services.definitions.ExpositionService
import com.kotlin.test_api.test_api.services.definitions.OeuvreService
import com.kotlin.test_api.test_api.services.definitions.SessionService
import org.springframework.stereotype.Service

@Service
class ExpositionServiceImpl
    (
    expositionRepository: ExpositionRepository,
    oeuvreService: OeuvreService,
    sessionService: SessionService
)
    : ExpositionService{

    private val expositionRepository: ExpositionRepository
    private val oeuvreService: OeuvreService
    private val sessionService: SessionService

    init {
        this.expositionRepository = expositionRepository
        this.oeuvreService = oeuvreService
        this.sessionService = sessionService
    }


    override fun findAll(): MutableList<ExpositionDTO> {
        val expositions = this.expositionRepository.findAll()
        return expositions.stream().map {
                expo -> expositionToDto(expo)
        }.toList()
    }

    override fun findById(id: Long): ExpositionDTO? {
        val exposition = this.expositionRepository.findById(id).orElse(null)
        if(exposition!= null){
            val expo = expositionToDto(exposition)
            val oeuvre = this.oeuvreService.findById(exposition.oeuvre.id!!)
            if(oeuvre != null){
                expo.oeuvre = oeuvreToDto(dtoToOeuvre(oeuvre))
            }
            val session = this.sessionService.findById(exposition.session.id!!)
            if(session != null){
                expo.session = sessionToDto(dtoToSession(session))
            }
            return expo
        }
        return null
    }

    override fun create(expositionDTO: ExpositionDTO): ExpositionDTO {
        val expo = dtoToExposition(expositionDTO)
        val oeuvre = this.oeuvreService.findById(expositionDTO.oeuvreId!!)
        if(oeuvre != null){
            expo.oeuvre = dtoToOeuvre(oeuvre)
        }
        val session = this.sessionService.findById(expositionDTO.sessionId!!)
        if(session != null){
            expo.session = dtoToSession(session)
        }
        val exposition = this.expositionRepository.save(expo)
        return expositionToDto(exposition)
    }

    override fun update(expositionDTO: ExpositionDTO, id: Long): ExpositionDTO? {
        val expositionFounded = this.expositionRepository.findById(id).orElse(null)
        if(expositionFounded != null){
            expositionFounded.titre = expositionDTO.titre
            expositionFounded.etat = expositionDTO.etat
            expositionFounded.dateExpo = expositionDTO.dateExpo
            expositionFounded.duree = expositionDTO.duree
            val oeuvre = this.oeuvreService.findById(expositionDTO.oeuvreId!!)
            if(oeuvre != null){
                expositionFounded.oeuvre = dtoToOeuvre(oeuvre)
            }
            val session = this.sessionService.findById(expositionDTO.sessionId!!)
            if(session != null){
                expositionFounded.session = dtoToSession(session)
            }
            return expositionToDto(expositionFounded)
        }
        return null
    }

    override fun delete(id: Long) : String? {
        val exposition = this.expositionRepository.findById(id).orElse(null)
        if(exposition != null){
            this.expositionRepository.delete(exposition)
            return "Suppression effectuée avec succès"
        }
        return null
    }
}