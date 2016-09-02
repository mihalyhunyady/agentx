package com.epam.agentx.game.model

import com.epam.agentx.map.model.Map
import com.epam.agentx.user.model.User

data class GameStatus(val currentPlayer: User, val map: Map, val association: Association, val score: Score)