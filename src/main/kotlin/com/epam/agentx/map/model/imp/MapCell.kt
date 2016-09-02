package com.epam.agentx.map.model

import com.epam.agentx.map.field.Team
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class MapCell(@Id @GeneratedValue val id: Int, val mapId: Int, val word: String, var teamType: Team, var visible: Boolean)