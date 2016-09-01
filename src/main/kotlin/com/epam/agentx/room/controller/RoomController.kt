package com.epam.agentx.room.controller

import com.epam.agentx.general.model.Response
import com.epam.agentx.room.model.Room
import com.epam.agentx.room.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController @Autowired constructor(val repository: RoomRepository) {

    @RequestMapping("/rooms", method = arrayOf(RequestMethod.GET))
    fun findAll() = repository.findAll()


    @RequestMapping("/room", method = arrayOf(RequestMethod.POST))
    fun createRoom(@RequestBody room: Room): Response {
        return Response(false, repository.save(room).id, 200)
    }


}