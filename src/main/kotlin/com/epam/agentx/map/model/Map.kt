package com.epam.agentx.map.model

import com.epam.agentx.map.field.Field
import org.hibernate.annotations.Cascade
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
data class Map(@Cascade(org.hibernate.annotations.CascadeType.ALL)
               @OneToMany var cells: Array<Array<MapCell>>) {


    fun revealCell(coordinate: Coordinate) {
        cells[coordinate.x][coordinate.y].visible = true
    }

    fun getField(coordinate: Coordinate): Field {
        return cells[coordinate.x][coordinate.y].fieldType
    }

    fun getWord(coordinate: Coordinate): String {
        return cells[coordinate.x][coordinate.y].word
    }
}