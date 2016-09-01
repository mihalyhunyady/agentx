package com.epam.agentx.player.model.imp

import com.epam.agentx.user.model.User

data class PlayerState(val user: User, val role: Role, val team: Team)

