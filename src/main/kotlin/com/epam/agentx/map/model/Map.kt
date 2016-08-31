package com.epam.agentx.map.model

import com.epam.agentx.map.field.Field
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Map(@Id @GeneratedValue val id: Int, val mapId: Int, val wordId: Int, val fieldType: Field, val col: Int, val row: Int, val visible: Boolean)