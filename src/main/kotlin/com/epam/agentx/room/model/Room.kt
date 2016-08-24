package com.epam.agentx.room.model

import com.epam.agentx.user.model.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Room(@Id @GeneratedValue val id: Long, val name: String, @OneToMany val users: List<User>)