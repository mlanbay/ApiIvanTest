package es.teamsilver.Api_Ivan_Test.dto

data class CreatePlayerInATeamRequest (
    var nombre: String,
    var posicion: String,
    var goles: Int,
    var id_equipo: Int
)