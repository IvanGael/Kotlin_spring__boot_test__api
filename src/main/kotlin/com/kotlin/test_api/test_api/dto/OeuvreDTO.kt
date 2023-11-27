package com.kotlin.test_api.test_api.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class OeuvreDTO(
    var id: Long? = null,

    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Size(min = 4, message = "this field require minimum 4 charaters.")
    var titre: String? = null,

    var dateCreation: LocalDate? = null,

    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    var prix: Double? = null,

    var annee: Int? = null,

    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    var rating: String? = null,

    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    var type: String? = null,


    var image: String? = null,

    var expositions: MutableList<ExpositionDTO>? = null
)

