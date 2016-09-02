package com.epam.agentx.map.model

import com.epam.agentx.map.field.Team
import org.hibernate.annotations.Cascade
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Map(@Cascade(org.hibernate.annotations.CascadeType.ALL)
               @OneToMany var cells: Array<Array<MapCell>>) {


    fun revealCell(coordinate: Coordinate) {
        cells[coordinate.x][coordinate.y].visible = true
    }

    fun getOwnerTeam(coordinate: Coordinate): Team {
        return cells[coordinate.x][coordinate.y].teamType
    }

    fun getWord(coordinate: Coordinate): String {
        return cells[coordinate.x][coordinate.y].word
    }
}