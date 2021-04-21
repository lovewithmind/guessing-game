package com.example.kotlin.game

import java.util.*

private val randomNumber = Random().nextInt(100)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Enter the number of players:")
    val numberOfPlayers = scanner.nextInt()
    val listOfPlayers: MutableList<Map<String, String>> = mutableListOf()

    for (playerIndex in 1..numberOfPlayers) {
        println("Add player $playerIndex name and age:")
        val player: MutableMap<String, String> = mutableMapOf()
        println("Name: ")
        player["name"] = scanner.next()
        println("Age: ")
        player["age"] = scanner.next()
        listOfPlayers.add(player)
    }
    var playerTurn = 0
    while (true) {
        val player = listOfPlayers[playerTurn]
        println("Player " + player["name"] + " turn:")
        println("Guess a number between 1 to 100")
        val guessedNumber = scanner.nextInt()
        if (guessedNumber == randomNumber) {
            println("Congratulation " + player["name"] + " " + player["age"] + " you won the game")
            break
        } else if (guessedNumber < randomNumber) {
            println("Guessed number is less than the random number")
        } else {
            println("Guessed number is more than the random number")
        }
        playerTurn++
        playerTurn %= numberOfPlayers
    }
}