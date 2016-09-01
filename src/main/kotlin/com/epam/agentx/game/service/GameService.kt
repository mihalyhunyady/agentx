package com.epam.agentx.game.service

import com.epam.agentx.map.model.MapCell
import com.epam.agentx.user.model.User

interface GameService {

    fun startGame(lambda: () -> Unit)

    fun selectCell(user: User, mapRow: MapCell, lambda: (Any) -> Unit)

    fun sendAssociation(user: User, word: String, number: Int, lambda: (Any) -> Unit)

}