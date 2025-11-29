package es.teamsilver.Api_Ivan_Test.controllers

import es.teamsilver.Api_Ivan_Test.dto.CreateEquipoRequest
import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerRequest
import es.teamsilver.Api_Ivan_Test.models.Equipo
import es.teamsilver.Api_Ivan_Test.models.Jugador
import es.teamsilver.Api_Ivan_Test.services.EquiposService
import es.teamsilver.Api_Ivan_Test.services.JugadoresService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/equipo/")
class EquipoController(var equiposService: EquiposService) {

    @GetMapping("/getAll")
    private fun getAllEquipos(): ResponseEntity<List<Equipo?>> {

        var equipoList = equiposService.getAllEquipos()

        return ResponseEntity<Equipo>.ok(equipoList)
    }

    @GetMapping("/getById/{id}")
    private fun getEquipoById(@PathVariable id : Int): ResponseEntity<Equipo> {

        var equipo = equiposService.getEquipoById(id)

        if (equipo!= null){
            return ResponseEntity<Equipo>.ok(equipo)
        }else{
            return ResponseEntity<Equipo>.notFound().build()
        }
    }

    @PutMapping("/{id_equipo}/addExistingPlayerById/{id_player}")
    private fun addExistingPlayerById(@PathVariable id_equipo: Int,@PathVariable id_player: Int): ResponseEntity<Jugador> {
        var jugador = equiposService.assignExistingPlayerToEquipo(id_equipo,id_player)

        if (jugador !=null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity<Jugador>.notFound().build()
        }

    }

    @PostMapping("/add")
    private fun addEquipo(@RequestBody equipo: CreateEquipoRequest): ResponseEntity<Equipo> {

        var equipo = equiposService.addEquipo(equipo)

        if (equipo!=null){
            return ResponseEntity<Equipo>.ok(equipo)
        }else{
            return ResponseEntity<Equipo>.badRequest().build()
        }


    }

    @PutMapping("/updateById/{id}")
    private fun updateEquipoById(@PathVariable id : Int, @RequestBody equipo: CreateEquipoRequest   ): ResponseEntity<Equipo> {

        var equipo = equiposService.updateEquipoById(id,equipo)

        if(equipo!=null){
            return ResponseEntity<Equipo>.ok(equipo)
        }else{
            return ResponseEntity<Equipo>.notFound().build()
        }

    }

    @DeleteMapping("/deleteById/{id}")
    private fun deleteEquipoById(@PathVariable id : Int): ResponseEntity<Equipo> {

        var equipo = equiposService.deleteEquipoById(id)

        if (equipo!= null){
            return ResponseEntity<Equipo>.ok(equipo)
        }else{
            return ResponseEntity<Equipo>.notFound().build()
        }
    }

}