package br.com.tairoroberto.games.service

import br.com.tairoroberto.games.model.Game
import br.com.tairoroberto.games.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameServices {

    @Autowired
    lateinit var gameRepository: GameRepository

    fun buscarTodos() : List<Game> {
        return gameRepository.findAll()
    }

    fun buscarPorNome(nome: String) : List<Game> {
        return gameRepository.findByNomeIgnoreCaseContaining(nome)
    }

    fun salvar(game: Game) {
        gameRepository.save(game)
    }

    fun deletar(id: String){
        gameRepository.deleteById(id)
    }
}