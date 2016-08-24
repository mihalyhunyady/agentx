package com.epam.agentx.user.model

import com.epam.agentx.statistic.model.Statistic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class User(@Id @GeneratedValue val id: Long, val displayName: String, val username: String, val password: String, @OneToOne val statistics: Statistic)