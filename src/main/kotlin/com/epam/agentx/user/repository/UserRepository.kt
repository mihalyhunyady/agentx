package com.epam.agentx.user.repository

import com.epam.agentx.user.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}