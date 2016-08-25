package com.epam.agentx.game.controller

import com.epam.agentx.game.controller.GameController.GameController
import com.epam.agentx.game.factory.GameFactory
import com.epam.agentx.room.repository.RoomRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class GameControllerTest {

    @Autowired
    lateinit var gameController: GameController

    @Mock
    lateinit var gameFactory: GameFactory
    @Mock
    lateinit var roomRepository: RoomRepository

    @Before
    fun setUp() {

    }

    @Test
    fun testStartGame() {
        gameController.startGame(0)

    }

    @Test
    fun testStopGame() {
        gameController.stopGame(0)
    }
}