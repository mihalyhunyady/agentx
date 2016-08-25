package com.epam.agentx.game.controller.model

import com.epam.agentx.room.model.Room
import java.net.ServerSocket

data class Game(val room: Room, val serverSocket: ServerSocket)