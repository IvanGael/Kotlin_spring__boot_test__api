package com.kotlin.test_api.test_api.dto

import java.time.LocalDate

data class ExpositionDTO(
    var id: Long? = null,
    var titre: String? = null,
    var etat: Int? = null,
    var dateExpo: LocalDate? = null,
    var duree: Int? = null,
    var sessionId: Long? = null,
    var oeuvreId: Long? = null,
    var session: SessionDTO? = null,
    var oeuvre: OeuvreDTO? = null
)

