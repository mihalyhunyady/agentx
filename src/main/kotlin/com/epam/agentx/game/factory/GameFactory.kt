package com.epam.agentx.game.factory

import com.epam.agentx.game.controller.model.Game
import com.epam.agentx.room.model.Room

interface GameFactory {
    fun createGame(room: Room): Game
}