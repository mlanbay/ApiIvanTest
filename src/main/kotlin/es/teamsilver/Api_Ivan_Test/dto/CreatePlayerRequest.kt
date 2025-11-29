package es.teamsilver.Api_Ivan_Test.dto

data class CreatePlayerRequest (
    val nombre: String,
    val posicion: String,
    var goles: Int
)