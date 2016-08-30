package com.epam.agentx.user.controller

import com.epam.agentx.general.model.Response
import com.epam.agentx.user.model.User
import com.epam.agentx.user.repository.UserRepository
import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController @Autowired constructor(val repository: UserRepository) {
    companion object : KLogging()


    @RequestMapping("/users", method = arrayOf(RequestMethod.GET))
    fun findAll() = repository.findAll()


    @RequestMapping("/user/:id", method = arrayOf(RequestMethod.GET))
    fun findAll(@PathVariable("id") id: Long) = repository.findOne(id)

    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestHeader username: String, @RequestHeader password: String): Response {
        val user: User? = repository.findByUsernameAndPassword(username, password)
        val response: Response?
        if (user != null) {
            response = Response(false, user.id, 200)
        } else {
            response = Response(true, "Not found", 404)
        }
        return response
    }
}