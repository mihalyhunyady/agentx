package com.epam.agentx.map.model

import com.epam.agentx.map.field.Team

class Map(var cells: Array<Array<MapCell>>) {


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