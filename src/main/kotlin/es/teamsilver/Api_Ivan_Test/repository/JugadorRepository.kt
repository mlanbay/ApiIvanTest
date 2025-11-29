package es.teamsilver.Api_Ivan_Test.repository

import es.teamsilver.Api_Ivan_Test.models.Jugador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JugadorRepository : JpaRepository<Jugador, Int>{

}