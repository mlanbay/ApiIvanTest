package es.teamsilver.Api_Ivan_Test.dto

import es.teamsilver.Api_Ivan_Test.models.Jugador
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

data class CreateEquipoRequest(
    var nombre: String = "",
    var estadio: String = "",
    var formacion: String = "",

)
