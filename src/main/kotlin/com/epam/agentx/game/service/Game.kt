package com.epam.agentx.game.controller.model

import com.epam.agentx.room.model.Room
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket

data class Game(val room: Room, val serverSocket: ServerSocket) {

    lateinit var thread: Thread
    var running: Boolean = false

    init {
        if (thread == null) {
            thread = Thread(Runnable {
                run()
            })
        }
    }

    fun start() {
        synchronized(running) {
            running = true
            thread.start()
        }
    }

    fun stop() {
        synchronized(running) {
            running = false
        }
    }

    private fun run() {
        while (running) {
            val connectionSocket: Socket = serverSocket.accept()
            val incommingStream = BufferedReader(InputStreamReader(connectionSocket.inputStream))
            val outgoingStream = DataOutputStream(connectionSocket.outputStream)

            val message = incommingStream.readLine()
            println("Received: $message")
            outgoingStream.writeBytes(message + "\n")
        }
    }
}