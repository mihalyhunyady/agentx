package com.epam.agentx.game.controller.GameController

import com.epam.agentx.game.factory.GameFactory
import com.epam.agentx.game.service.Game
import com.epam.agentx.room.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class GameController @Autowired constructor(val roomRepository: RoomRepository, val gameFactory: GameFactory) {
    val runningGames = HashMap<Long, Game>()

    fun startGame(roomId: Long) {
        val room = roomRepository.findOne(roomId)
        val game = gameFactory.createGame(room)
        runningGames.putIfAbsent(roomId, game)
        game.start()
    }


    fun stopGame(roomId: Long) {
        val game = runningGames[roomId]
        game?.let {
            game.stop()
            runningGames.remove(roomId)
        }
    }


    fun getPort(roomId: Long): Int {
        return runningGames[roomId]?.serverSocket?.localPort ?: 0
    }
}