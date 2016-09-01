package com.epam.agentx.game.service

import com.epam.agentx.game.model.GameStatus
import com.epam.agentx.map.model.MapCell
import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

interface GameService {

    fun joinGame(lambda: (p: Players) -> Unit)

    fun leaveGame(lambda: (p: Players) -> Unit)

    fun startGame(lambda: (gs: GameStatus, p: Players) -> Unit)

    fun selectCell(user: User, mapRow: MapCell, lambda: (Any) -> Unit)

    fun sendAssociation(user: User, word: String, number: Int, lambda: (Any) -> Unit)

}