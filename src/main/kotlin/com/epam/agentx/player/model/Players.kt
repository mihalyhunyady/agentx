package com.epam.agentx.player.model

import com.epam.agentx.map.field.Team
import com.epam.agentx.player.model.imp.Role
import com.epam.agentx.user.model.User

interface Players {
    val currentPlayer: User
    val currentPlayerTeam: Team
    val currentPlayerRole: Role
    fun nextPlayer()
}