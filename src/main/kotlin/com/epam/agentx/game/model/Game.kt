package com.epam.agentx.game.model

import com.epam.agentx.map.field.Team
import com.epam.agentx.player.model.Players

class Game(val players: Players, val map: com.epam.agentx.map.model.Map, var score: Score, var association: Association = Association("", 0)) {
    lateinit var teamCount: MutableMap<Team, Int>
    fun asStatus(): GameStatus {
        return GameStatus(players.currentPlayer, map, association, score)
    }

}