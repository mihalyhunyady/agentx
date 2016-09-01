package com.epam.agentx.map.model

import com.epam.agentx.map.field.Field
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class MapCell(@Id @GeneratedValue val id: Int, val mapId: Int, val word: String, var fieldType: Field, var visible: Boolean)