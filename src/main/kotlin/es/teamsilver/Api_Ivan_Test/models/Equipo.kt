package es.teamsilver.Api_Ivan_Test.models

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Equipo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int = 0,
    var nombre: String = "",
    var estadio: String = "",
    var formacion: String = "",

    @OneToMany(mappedBy = "equipo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var jugadores: MutableList<Jugador> = mutableListOf()

)