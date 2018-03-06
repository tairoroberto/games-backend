package br.com.tairoroberto.games.controller

import br.com.tairoroberto.games.model.Game
import br.com.tairoroberto.games.service.GameServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = ["/game"])
class GameController {

    @Autowired
    lateinit var gameServices: GameServices

    @GetMapping
    fun buscarTodos(): List<Game> {
        return gameServices.buscarTodos()
    }

    @GetMapping(value = ["/titulo/{titulo}"])
    fun buscarPorNome(@PathVariable(value = "titulo") titulo: String): List<Game> {
        return gameServices.buscarPorNome(titulo)
    }

    @PostMapping
    fun salvar(@RequestBody game: Game) {
        gameServices.salvar(game)
    }

    @DeleteMapping("{id}")
    fun deletar(@PathVariable(value = "id") id: String) {
        gameServices.deletar(id)
    }
}