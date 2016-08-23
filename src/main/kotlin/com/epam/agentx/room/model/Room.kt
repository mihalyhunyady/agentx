package com.epam.agentx.room.model

import com.epam.agentx.user.model.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Room(@Id @GeneratedValue val id: Long, val name: String, val users: List<User>)