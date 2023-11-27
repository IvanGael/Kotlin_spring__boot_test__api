package com.kotlin.test_api.test_api.mappers

import com.kotlin.test_api.test_api.dto.ExpositionDTO
import com.kotlin.test_api.test_api.dto.OeuvreDTO
import com.kotlin.test_api.test_api.dto.SessionDTO
import com.kotlin.test_api.test_api.models.Exposition
import com.kotlin.test_api.test_api.models.Oeuvre
import com.kotlin.test_api.test_api.models.Session

object EntityMapper {

    // Fonction pour convertir ExpositionDTO en Exposition
    fun dtoToExposition(expositionDTO: ExpositionDTO): Exposition {
        return Exposition(
            id = expositionDTO.id,
            titre = expositionDTO.titre,
            etat = expositionDTO.etat,
            dateExpo = expositionDTO.dateExpo,
            duree = expositionDTO.duree,
            session = Session(),
            oeuvre = Oeuvre()
        )
    }


    // Fonction pour convertir Exposition en ExpositionDTO
    fun expositionToDto(exposition: Exposition): ExpositionDTO {
        return ExpositionDTO(
            id = exposition.id,
            titre = exposition.titre,
            etat = exposition.etat,
            dateExpo = exposition.dateExpo,
            duree = exposition.duree,
            sessionId = exposition.session.id,
            oeuvreId = exposition.oeuvre.id
        )
    }


    // Fonction pour convertir OeuvreDTO en Oeuvre
    fun dtoToOeuvre(oeuvreDTO : OeuvreDTO) : Oeuvre {
        return Oeuvre(
            id = oeuvreDTO.id,
            titre = oeuvreDTO.titre,
            dateCreation = oeuvreDTO.dateCreation,
            prix = oeuvreDTO.prix,
            annee = oeuvreDTO.annee,
            rating = oeuvreDTO.rating,
            type = oeuvreDTO.type,
            image = oeuvreDTO.image,
            //expositions = oeuvreDTO.expositions!!.stream().map { expo -> dtoToExposition(expo) }.toList()
        )
    }

    // Fonction pour convertir Oeuvre en OeuvreDTO
    fun oeuvreToDto(oeuvre: Oeuvre) : OeuvreDTO {
        return OeuvreDTO(
            id = oeuvre.id,
            titre = oeuvre.titre,
            dateCreation = oeuvre.dateCreation,
            prix = oeuvre.prix,
            annee = oeuvre.annee,
            rating = oeuvre.rating,
            type = oeuvre.type,
            image = oeuvre.image,
            //expositions = oeuvre.expositions!!.stream().map { expo -> expositionToDto(expo) }.toList()
        )
    }


    // Fonction pour convertir SessionDTO en Session
    fun dtoToSession(sessionDTO: SessionDTO) : Session {
        return Session(
            id = sessionDTO.id,
            titre = sessionDTO.titre,
            dateDebut = sessionDTO.dateDebut,
            dateFin = sessionDTO.dateFin,
            localisation = sessionDTO.localisation,
            //expositions = sessionDTO.expositions!!.stream().map { expo -> dtoToExposition(expo) }.toList()
        )
    }

    // Fonction pour convertir Session en SessionDTO
    fun sessionToDto(session: Session) : SessionDTO {
        return SessionDTO(
            id = session.id,
            titre = session.titre,
            dateDebut = session.dateDebut,
            dateFin = session.dateFin,
            localisation = session.localisation,
            //expositions = session.expositions!!.stream().map { expo -> expositionToDto(expo) }.toList()
        )
    }

}