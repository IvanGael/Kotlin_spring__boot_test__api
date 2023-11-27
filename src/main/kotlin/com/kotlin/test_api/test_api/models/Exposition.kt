package com.kotlin.test_api.test_api.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDate


@Entity
@Table(name = "expositions")
class Exposition (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var titre: String? = null,

    @Column(nullable = false)
    var etat: Int? = null,


    var dateExpo: LocalDate? = null,

    @Column(nullable = false)
    var duree: Int? = null,

    @ManyToOne
    @JoinColumn(name = "sessionId")
    var session: Session = Session(),

    @ManyToOne
    @JoinColumn(name = "oeuvreId")
    var oeuvre: Oeuvre = Oeuvre(),


)
