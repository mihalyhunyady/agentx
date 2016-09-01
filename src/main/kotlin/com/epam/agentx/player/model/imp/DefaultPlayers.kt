package com.epam.agentx.player.model.imp

import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

class DefaultPlayers : Players {

    var currentPlayer: Int = 0
    lateinit var users: Array<PlayerState>

    override fun nextPlayer() {
        currentPlayer += 1
    }

    override fun currentPlayer(): User {
        return users[currentPlayer % users.size].user
    }
}