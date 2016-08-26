package com.epam.agentx.game.factory.imp

import com.epam.agentx.game.factory.GameFactory
import com.epam.agentx.game.service.Game
import com.epam.agentx.room.model.Room
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.net.ServerSocket


@RunWith(SpringRunner::class)
@SpringBootTest
class GameSocketFactoryTest {

    @Mock
    lateinit var serverSocket: ServerSocket

    @Mock
    lateinit var room: Room

    lateinit var gameFactory: GameFactory


    @Before
    fun setUp() {
        gameFactory = GameSocketFactory()
    }

    @Test
    fun testCreateGameReturnsAGame() {
        val expected = Game(room, serverSocket)
        Mockito.`when`(gameFactory.createGame(room)).thenReturn(expected)
        val result = gameFactory.createGame(room)
        Assert.assertEquals(expected, result)
    }
}