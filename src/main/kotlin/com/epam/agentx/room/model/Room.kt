package com.epam.agentx.room.model

import com.epam.agentx.user.model.User
import org.hibernate.annotations.Cascade
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Room(@Id @GeneratedValue val id: Long = 0, val name: String = "", @Cascade(value = CascadeType.SAVE_UPDATE) @OneToMany var users: ArrayList<User> = ArrayList())