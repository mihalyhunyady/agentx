package com.epam.agentx.room.controller

import com.epam.agentx.room.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController @Autowired constructor(val repository: RoomRepository) {

    @RequestMapping("/rooms")
    fun findAll() = repository.findAll()
}