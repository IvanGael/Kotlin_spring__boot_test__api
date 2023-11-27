package com.kotlin.test_api.test_api.dto

import java.time.LocalDate

data class SessionDTO(
    var id: Long? = null,
    var titre: String? = null,
    var dateDebut: LocalDate? = null,
    var dateFin: LocalDate? = null,
    var localisation: String? = null,
    var expositions: MutableList<ExpositionDTO>? = null
)

