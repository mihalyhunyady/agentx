package com.epam.agentx.player.model.imp

import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

class DefaultPlayers : Players {

    var currentPlayerCounter: Int = 0
    lateinit var users: Array<PlayerState>

    override fun nextPlayer() {
        currentPlayerCounter += 1
    }

    override var currentPlayer: User = User()
        get() = users[currentPlayerCounter % users.size].user


}