package com.epam.agentx.game.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Word(@Id @GeneratedValue val id: Long = 0, val text: String = "")