package es.teamsilver.Api_Ivan_Test.services

import es.teamsilver.Api_Ivan_Test.controllers.EquipoController
import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerInATeamRequest
import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerRequest
import es.teamsilver.Api_Ivan_Test.models.Equipo
import es.teamsilver.Api_Ivan_Test.models.Jugador
import es.teamsilver.Api_Ivan_Test.repository.EquipoRepository
import es.teamsilver.Api_Ivan_Test.repository.JugadorRepository
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@Service
class JugadoresService (var repo: JugadorRepository, var repoEquipo: EquipoRepository){


    fun addPlayer(createPlayerRequest: CreatePlayerRequest): Jugador {
        var player = Jugador()
        player.nombre=createPlayerRequest.nombre
        player.posicion=createPlayerRequest.posicion
        player.goles=createPlayerRequest.goles

        return repo.save(player)

    }


    fun addPlayerToEquipo(jugadorRequest: CreatePlayerInATeamRequest): Jugador? {
        val equipo = repoEquipo.findById(jugadorRequest.id_equipo).getOrNull() ?: return null

        val jugador = Jugador(
            nombre = jugadorRequest.nombre,
            posicion = jugadorRequest.posicion,
            goles = jugadorRequest.goles,
            equipo = equipo
        )

        return repo.save(jugador)          // Gracias al cascade, guarda el jugador

    }

    fun getPlayerById(id: Int): Jugador? {

        return repo.findById(id).getOrNull()

    }

    fun getAllPlayers(): List<Jugador> {
        return repo.findAll()
    }

    fun updatePlayerById(id: Int, createPlayerRequest: CreatePlayerInATeamRequest): Jugador? {

        var player = repo.findById(id).getOrNull()

        val equipo = repoEquipo.findById(createPlayerRequest.id_equipo).getOrNull() ?: return null


        if (player != null){
            player.nombre = createPlayerRequest.nombre
            player.posicion = createPlayerRequest.posicion
            player.goles = createPlayerRequest.goles
            player.equipo = equipo
            return repo.save(player)
        }else{
            return null
        }



    }

    fun deletePlayerById(id: Int) : Jugador?{

        var player = repo.findById(id).getOrNull()

        if (player!=null){
            repo.delete(player)
            return player
        }else{
            return null
        }

    }

}