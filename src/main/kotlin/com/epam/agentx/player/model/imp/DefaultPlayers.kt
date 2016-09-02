package com.epam.agentx.player.model.imp

import com.epam.agentx.map.field.Team
import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

class DefaultPlayers : Players {
    override val currentPlayerTeam: Team
        get() = users[currentPlayerCounter].team
    override val currentPlayerRole: Role
        get() = users[currentPlayerCounter].role
    override val currentPlayer: User
        get() = users[currentPlayerCounter % users.size].user

    var currentPlayerCounter: Int = 0
    lateinit var users: Array<PlayerState>

    override fun nextPlayer() {
        currentPlayerCounter += 1
    }


}