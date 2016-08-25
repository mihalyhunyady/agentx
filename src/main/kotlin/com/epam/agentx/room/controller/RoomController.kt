package com.epam.agentx.room.controller

import com.epam.agentx.game.controller.GameController.GameController
import com.epam.agentx.general.model.Response
import com.epam.agentx.room.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController @Autowired constructor(val repository: RoomRepository, val gameController: GameController) {

    @RequestMapping("/rooms")
    fun findAll() = repository.findAll()

    @RequestMapping("/room/:id")
    fun startRoom(@PathVariable("id") roomId: Int) {
        gameController.startGame(roomId)
    }

    @RequestMapping(value = "/room/:id", method = arrayOf(RequestMethod.GET))
    fun getPort(@PathVariable("id") roomId: Int): Response {
        return Response(false, gameController.getPort(roomId), 200)
    }
}