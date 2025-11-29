package es.teamsilver.Api_Ivan_Test.repository

import es.teamsilver.Api_Ivan_Test.models.Equipo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder

interface EquipoRepository : JpaRepository<Equipo,Int> {
}