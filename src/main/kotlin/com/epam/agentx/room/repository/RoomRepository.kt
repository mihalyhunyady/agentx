package com.epam.agentx.room.repository

import com.epam.agentx.room.model.Room
import org.springframework.data.repository.CrudRepository

interface RoomRepository : CrudRepository<Room, Long> {
    fun findByName(name: String): List<Room>
}