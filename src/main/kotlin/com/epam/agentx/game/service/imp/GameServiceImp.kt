package com.epam.agentx.game.service.imp

import com.epam.agentx.game.model.Game
import com.epam.agentx.game.service.GameService
import com.epam.agentx.map.model.MapCell
import com.epam.agentx.user.model.User

class GameServiceImp : GameService {
    lateinit var game: Game

    override fun startGame(lambda: () -> Unit) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectCell(user: User, mapRow: MapCell, lambda: (Any) -> Unit) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendAssociation(user: User, word: String, number: Int, lambda: (Any) -> Unit) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}