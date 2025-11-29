package es.teamsilver.Api_Ivan_Test.controllers

import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerInATeamRequest
import es.teamsilver.Api_Ivan_Test.models.Jugador
import es.teamsilver.Api_Ivan_Test.dto.CreatePlayerRequest
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
import java.util.Optional

@RestController
@RequestMapping("/player/")
class PlayerController(var jugadoresService: JugadoresService) {

    @GetMapping("/getAll")
    private fun getAllPlayers(): ResponseEntity<List<Jugador>> {

        var playerList = jugadoresService.getAllPlayers()

        return ResponseEntity<Jugador>.ok(playerList)
    }

    @GetMapping("/getById/{id}")
    private fun getPlayerById(@PathVariable id : Int): ResponseEntity<Jugador> {

        var player = jugadoresService.getPlayerById(id)

        if (player!= null){
            return ResponseEntity<Jugador>.ok(player)
        }else{
            return ResponseEntity<Jugador>.notFound().build()
        }
    }


    @PostMapping("/add")
    private fun addPlayer(@RequestBody player: CreatePlayerRequest): ResponseEntity<Jugador> {

        var jugador = jugadoresService.addPlayer(player)

        return ResponseEntity<Jugador>.ok(jugador)
    }

    @PostMapping("/addInTeam")
    private fun addPlayerInTeam(@RequestBody player: CreatePlayerInATeamRequest): ResponseEntity<Jugador> {

        var jugador = jugadoresService.addPlayerToEquipo(player)

        return ResponseEntity<Jugador>.ok(jugador)
    }



    @PutMapping("/updateById/{id}")
    private fun updatePlayerById(@PathVariable id : Int, @RequestBody player: CreatePlayerInATeamRequest): ResponseEntity<Jugador> {

        var jugador = jugadoresService.updatePlayerById(id,player)

        if(jugador!=null){
            return ResponseEntity<Jugador>.ok(jugador)
        }else{
            return ResponseEntity<Jugador>.notFound().build()
        }

    }

    @DeleteMapping("/deleteById/{id}")
    private fun deletePlayerById(@PathVariable id : Int): ResponseEntity<Jugador> {

        var player = jugadoresService.deletePlayerById(id)

        if (player!= null){
            return ResponseEntity<Jugador>.ok(player)
        }else{
            return ResponseEntity<Jugador>.notFound().build()
        }
    }


}