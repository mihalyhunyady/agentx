package com.epam.agentx.user

import com.epam.agentx.user.repository.UserRepository
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

class UserController @Autowired constructor(val repository: UserRepository) {
    companion object : KLogging()


    @RequestMapping("/users", method = arrayOf(RequestMethod.GET))
    fun findAll() = repository.findAll()


    @RequestMapping("/user/:id", method = arrayOf(RequestMethod.GET))
    fun findAll(@PathVariable("id") id: Long) = repository.findOne(id)

    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestHeader header: RequestHeader) {
        logger.debug { header.value }

    }
}