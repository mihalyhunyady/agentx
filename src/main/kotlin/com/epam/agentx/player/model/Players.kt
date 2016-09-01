package com.epam.agentx.player.model

import com.epam.agentx.user.model.User

interface Players {
    val currentPlayer: User
    fun nextPlayer()
}