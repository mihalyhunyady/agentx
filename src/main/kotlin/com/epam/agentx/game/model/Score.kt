package com.epam.agentx.game.model

import com.epam.agentx.player.model.imp.Team

data class Score(var score: Map<Team, Int>)