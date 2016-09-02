package com.epam.agentx.game.service.imp

import com.epam.agentx.game.model.*
import com.epam.agentx.game.service.GameService
import com.epam.agentx.map.field.Team
import com.epam.agentx.map.model.Coordinate
import com.epam.agentx.map.model.Map
import com.epam.agentx.player.model.Players
import com.epam.agentx.player.model.imp.Role
import com.epam.agentx.user.model.User
import org.springframework.stereotype.Component

@Component("gameService")
class GameServiceImp(p: Players) : GameService {
    val game: Game
    val SCORE_PENALTY = -100
    val SCORE_NORMAL = 1

    init {
        game = Game(p, generateMap(), generateInitialScore())
    }

    private fun generateInitialScore(): Score {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun generateMap(): Map {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //TODO resorting player's list
    override fun startGame(lambda: (gs: GameStatus, p: Players) -> Unit) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectCell(user: User, coordinate: Coordinate, lambda: (Any) -> Unit) {
        if (isValidGuesser(user)) {
            reveallCell(coordinate)
            val team = game.map.getOwnerTeam(coordinate)
            val gameEvent: GameEvent
            if (isItTheKiller(team)) {
                increaseScore(team, SCORE_PENALTY)
                gameEvent = GameEvent(Event.STOP, game.asStatus(), "Stepped into killer, stopping game")
            } else {
                if (isItYourTeam(team)) {
                    decreaseAssociationCount()
                    if (isEndOfYourTurn()) {
                        nextPlayer()
                    }
                } else {
                    nextPlayer()
                }
                increaseScore(team, SCORE_NORMAL)
                decreaseFieldCount()

                if (isEndGame()) {
                    gameEvent = GameEvent(Event.STOP, game.asStatus(), "Someone won")
                } else {
                    gameEvent = GameEvent(Event.STEP, game.asStatus(), "normal step")
                }

            }
            lambda.invoke(gameEvent)
        }
    }

    private fun reveallCell(coordinate: Coordinate) {
        game.map.revealCell(coordinate)
    }

    private fun decreaseAssociationCount() {
        game.association.number.minus(1)
    }

    private fun increaseScore(team: Team, score: Int) {
        game.score.score[team]?.plus(score)
    }

    private fun isEndOfYourTurn() = game.association.number.equals(0)

    private fun isItYourTeam(team: Team) = team.equals(game.players.currentPlayerTeam)

    private fun isItTheKiller(team: Team) = team.equals(Team.KILLER)

    private fun isEndGame() = game.teamCount[game.players.currentPlayerTeam]?.equals(0) ?: false

    private fun decreaseFieldCount() {
        game.teamCount[game.players.currentPlayerTeam]?.minus(1)
    }

    override fun sendAssociation(user: User, word: String, number: Int, lambda: (Any) -> Unit) {
        if (isValidCreative(user)) {
            game.association = Association(word, number)
            lambda.invoke(GameEvent(Event.STEP, game.asStatus(), "Successfully associated"))
        }
    }

    private fun isValidCreative(user: User) = user.equals(game.players.currentPlayer) && checkCurrentPlayerRole(Role.CREATIVE)

    private fun isValidGuesser(user: User) = user.equals(game.players.currentPlayer) && checkCurrentPlayerRole(Role.GUESSER)

    private fun checkCurrentPlayerRole(role: Role): Boolean {
        return game.players.currentPlayerRole.equals(role)
    }

    private fun nextPlayer() {
        game.players.nextPlayer()
    }
}