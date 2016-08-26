package com.epam.agentx.game.factory


import com.epam.agentx.game.service.Game
import com.epam.agentx.room.model.Room

interface GameFactory {
    fun createGame(room: Room): Game
}