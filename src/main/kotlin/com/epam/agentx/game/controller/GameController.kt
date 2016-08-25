package com.epam.agentx.game.controller.GameController

import com.epam.agentx.game.controller.model.Game
import com.epam.agentx.room.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.ServerSocket
import java.util.*

@Component
class GameController @Autowired constructor(val roomRepository: RoomRepository) {
    val runningGames = HashMap<Long, Game>()

    fun startGame(roomId: Long) {
        val socket = ServerSocket(generateRandomPort())
        val room = roomRepository.findOne(roomId)
        val game = Game(room, socket)
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


    private fun generateRandomPort(): Int {
        val random = Random()
        return random.nextInt(5000) + 5000
    }
}