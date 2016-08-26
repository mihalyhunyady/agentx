package com.epam.agentx.room.model

import com.epam.agentx.user.model.User
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Room(@Id @GeneratedValue val id: Long = 0, val name: String = "", var users: ArrayList<User> = ArrayList())