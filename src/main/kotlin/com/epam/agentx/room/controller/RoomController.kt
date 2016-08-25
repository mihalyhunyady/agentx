package com.epam.agentx.room.controller

import com.epam.agentx.game.controller.GameController.GameController
import com.epam.agentx.general.model.Response
import com.epam.agentx.room.model.Room
import com.epam.agentx.room.repository.RoomRepository
import com.epam.agentx.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class RoomController @Autowired constructor(val repository: RoomRepository, val userRepository: UserRepository, val gameController: GameController) {

    @RequestMapping("/rooms", method = arrayOf(RequestMethod.GET))
    fun findAll() = repository.findAll()


    @RequestMapping("/room", method = arrayOf(RequestMethod.POST))
    fun createRoom(@RequestBody room: Room): Response {
        return Response(false, repository.save(room).id, 200)
    }

    @RequestMapping("/room/:id", method = arrayOf(RequestMethod.PUT))
    fun joinRoom(@PathVariable("id") roomId: Long, @RequestBody userId: Long): Response {
        val user = userRepository.findOne(userId)
        val room = repository.findOne(roomId)
        room.users.add(user)
        return Response(false, "${user.displayName} joined to room: ${room.name}", 200)
    }


    @RequestMapping("/room/:id", method = arrayOf(RequestMethod.POST))
    fun startRoom(@PathVariable("id") roomId: Int) {
        gameController.startGame(roomId)
    }

    @RequestMapping(value = "/room/:id", method = arrayOf(RequestMethod.GET))
    fun getPort(@PathVariable("id") roomId: Int): Response {
        val port: Int? = gameController.getPort(roomId)
        if (port != null)
            return Response(false, port, 200)
        else
            return Response(true, "No such room!", 404)
    }
}