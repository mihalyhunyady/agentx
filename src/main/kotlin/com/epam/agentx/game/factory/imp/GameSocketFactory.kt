package com.epam.agentx.game.factory.imp

import com.epam.agentx.game.controller.model.Game
import com.epam.agentx.game.factory.GameFactory
import com.epam.agentx.room.model.Room
import org.springframework.stereotype.Component
import java.net.ServerSocket
import java.util.*

@Component("gameFactory")
class GameSocketFactory : GameFactory {

    override fun createGame(room: Room): Game {
        val socket = ServerSocket(generateRandomPort())
        val game = Game(room, socket)
        return game
    }

    private fun generateRandomPort(): Int {
        val random = Random()
        return random.nextInt(5000) + 5000
    }
}