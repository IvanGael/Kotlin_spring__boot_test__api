package com.kotlin.test_api.test_api.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*


@Entity
@Table(name = "oeuvres")
data class Oeuvre (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var titre: String? = null,


    var dateCreation: LocalDate? = null,

    @Column(nullable = false)
    var prix: Double? = null,


    var annee: Int? = null,

    @Column(nullable = false)
    var rating: String? = null,

    @Column(nullable = false)
    var type: String? = null,

    var image: String? = null,

    /*@OneToMany(mappedBy = "oeuvre", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var expositions: MutableList<Exposition> = ArrayList()*/
)
