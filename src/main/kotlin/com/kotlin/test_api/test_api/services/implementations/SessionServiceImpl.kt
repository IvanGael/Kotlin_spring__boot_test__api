package com.kotlin.test_api.test_api.services.implementations

import com.kotlin.test_api.test_api.dto.SessionDTO
import com.kotlin.test_api.test_api.mappers.EntityMapper.dtoToSession
import com.kotlin.test_api.test_api.mappers.EntityMapper.sessionToDto
import com.kotlin.test_api.test_api.repositories.SessionRepository
import com.kotlin.test_api.test_api.services.definitions.SessionService
import org.springframework.stereotype.Service

@Service
class SessionServiceImpl (
    sessionRepository: SessionRepository
        )
    : SessionService {

    private val sessionRepository: SessionRepository

    init {
        this.sessionRepository = sessionRepository
    }

    override fun findAll(): MutableList<SessionDTO> {
        val sessions = this.sessionRepository.findAll()
        return sessions.stream().map { session ->  sessionToDto(session)}.toList()
    }

    override fun findById(id: Long): SessionDTO? {
        val session = this.sessionRepository.findById(id).orElse(null)
        if(session != null){
            return sessionToDto(session)
        }
        return null
    }

    override fun create(sessionDTO: SessionDTO): SessionDTO {
        val session = this.sessionRepository.save(dtoToSession(sessionDTO))
        return sessionToDto(session)
    }

    override fun update(sessionDTO: SessionDTO, id: Long): SessionDTO? {
        val sessionFounded = this.sessionRepository.findById(id).orElse(null)
        if(sessionFounded != null){
          sessionFounded.titre = sessionDTO.titre
          sessionFounded.dateDebut = sessionDTO.dateDebut
          sessionFounded.dateFin = sessionDTO.dateFin
          sessionFounded.localisation = sessionDTO.localisation
          return sessionToDto(sessionFounded)
        }
        return null
    }

    override fun delete(id: Long): String? {
        val session = this.sessionRepository.findById(id).orElse(null)
        if(session != null){
            this.sessionRepository.delete(session)
            return "Suppression effectuée avec succès"
        }
        return null
    }
}