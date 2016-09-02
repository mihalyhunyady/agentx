package com.epam.agentx.game.service

import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

interface LobbyService {

    fun joinGame(user: User, lambda: (p: Players) -> Unit)

    fun leaveGame(user: User, lambda: (p: Players) -> Unit)
}