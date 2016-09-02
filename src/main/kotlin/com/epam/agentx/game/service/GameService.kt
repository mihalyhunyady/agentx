package com.epam.agentx.game.service

import com.epam.agentx.game.model.GameStatus
import com.epam.agentx.map.model.Coordinate
import com.epam.agentx.player.model.Players
import com.epam.agentx.user.model.User

interface GameService {

    fun startGame(lambda: (gs: GameStatus, p: Players) -> Unit)

    fun selectCell(user: User, coordinate: Coordinate, lambda: (Any) -> Unit)

    fun sendAssociation(user: User, word: String, number: Int, lambda: (Any) -> Unit)

}