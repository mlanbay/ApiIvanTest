package es.teamsilver.Api_Ivan_Test.services

import es.teamsilver.Api_Ivan_Test.dto.CreateEquipoRequest
import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerRequest
import es.teamsilver.Api_Ivan_Test.models.Equipo
import es.teamsilver.Api_Ivan_Test.models.Jugador
import es.teamsilver.Api_Ivan_Test.repository.EquipoRepository
import es.teamsilver.Api_Ivan_Test.repository.JugadorRepository
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@Service
class EquiposService(var repo: EquipoRepository, var jugadorRepo: JugadorRepository) {

    fun addEquipo(createEquipoRequest: CreateEquipoRequest): Equipo? {

        var equipo = Equipo()
        equipo.nombre= createEquipoRequest.nombre
        equipo.estadio = createEquipoRequest.estadio
        equipo.formacion = createEquipoRequest.formacion

        return repo.save(equipo)

    }
    fun getAllEquipos(): List<Equipo?> {
        return repo.findAll()
    }
    fun getEquipoById(id: Int): Equipo? {
        return repo.findById(id).getOrNull()
    }
    fun updateEquipoById(id:Int, createEquipoRequest: CreateEquipoRequest): Equipo? {


        var equipo = repo.findById(id).getOrNull()

        if (equipo != null){
            equipo.nombre = createEquipoRequest.nombre
            equipo.estadio = createEquipoRequest.estadio
            equipo.formacion = createEquipoRequest.formacion

            return repo.save(equipo)
        }else{
            return null
        }

    }
    fun deleteEquipoById(id: Int): Equipo? {

        var equipo = repo.findById(id).getOrNull()

        if (equipo!=null){
            repo.delete(equipo)
            return equipo
        }else{
            return null
        }
    }


    fun assignExistingPlayerToEquipo(idEquipo: Int, idJugador: Int): Jugador? {

        val equipo = repo.findById(idEquipo).getOrNull() ?: return null
        val jugador = jugadorRepo.findById(idJugador).getOrNull() ?: return null

        jugador.equipo = equipo

        return jugadorRepo.save(jugador)
    }

}