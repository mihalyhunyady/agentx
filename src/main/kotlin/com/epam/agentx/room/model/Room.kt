package com.epam.agentx.room.model

import com.epam.agentx.user.model.User
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Room(@Id @GeneratedValue val id: Long = 0, val name: String = "", @OneToMany var users: ArrayList<User> = ArrayList())