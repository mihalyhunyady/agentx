package com.epam.agentx.game.model

import com.epam.agentx.map.model.Map
import com.epam.agentx.player.model.Players

class Game(val players: Players, val map: Map, var association: String, var score: Score) {

    fun asStatus(): GameStatus {
        return GameStatus(players.currentPlayer, map, association, score)
    }

    fun nextPlayer() {
        players.nextPlayer()
    }

}