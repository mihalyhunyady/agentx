package com.epam.agentx.game.controller.GameController

import com.epam.agentx.game.model.Event
import com.epam.agentx.game.model.GameEvent
import com.epam.agentx.game.service.GameService
import com.epam.agentx.general.model.Response
import com.epam.agentx.room.repository.RoomRepository
import com.epam.agentx.user.model.User
import com.epam.agentx.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
class GameController @Autowired constructor(val userRepository: UserRepository, val roomRepository: RoomRepository, val template: SimpMessagingTemplate, val gameService: GameService) {

    @RequestMapping("/room/:id", method = arrayOf(RequestMethod.PUT))
    fun joinRoom(@PathVariable("id") roomId: Long, @RequestBody event: GameEvent): Response {
        val user = userRepository.findOne((event.content as User).id)
        val room = roomRepository.findOne(roomId)
        room.addUser(user)
        if (event.event.equals(Event.JOIN)) {
            gameService.joinGame { players ->
                this.template.convertAndSend("/game/$roomId", GameEvent(Event.JOIN, players, "someone joined to the room"))
            }
            return Response(false, "${user.displayName} joined to room: ${room.name}", 200)

        } else if (event.event.equals(Event.LEAVE)) {
            gameService.leaveGame { players ->
                this.template.convertAndSend("/game/$roomId", GameEvent(Event.JOIN, players, "someone leaved the room"))
            }
            return Response(false, "${user.displayName} leaved to room: ${room.name}", 200)
        } else {
            return Response(true, "No such operation", 503)
        }
    }


    @RequestMapping("/room/:id", method = arrayOf(RequestMethod.POST))
    fun startGame(@PathVariable("id") roomId: Long): Response {
        gameService.startGame { gameStatus, players ->
            this.template.convertAndSend("/game/$roomId", GameEvent(Event.START, arrayOf(gameStatus, players), "Game started"))
        }
        return Response(false, "game started", 200)
    }


    @RequestMapping("/room/:id", method = arrayOf(RequestMethod.DELETE))
    fun stopGame(@PathVariable("id") roomId: Long): Response {
        this.template.convertAndSend("/game/$roomId", Event.STOP)
        return Response(false, "game stopped", 200)
    }

}