package com.kotlin.test_api.test_api.models

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "sessions")
data class Session(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var titre: String? = null,


    var dateDebut: LocalDate? = null,


    var dateFin: LocalDate? = null,

    @Column(nullable = false)
    var localisation: String? = null,

    /*@OneToMany(mappedBy = "session", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var expositions: MutableList<Exposition> = ArrayList()*/
)
