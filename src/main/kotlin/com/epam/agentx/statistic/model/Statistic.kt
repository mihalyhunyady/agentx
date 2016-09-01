package com.epam.agentx.statistic.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Statistic(@Id @GeneratedValue val id: Long = 0, val userId: Int = 0)