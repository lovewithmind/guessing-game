## Multiplayer Guessing Game

## How to play the game

This game is a multiplayer game where the system randomly choose a number between 1 - 100, and the players have to guess the random number by consecutively asking the system to tell if there guessed number is greater than or less than the random number.

Game play of MultiplePlayer Guessing Game contains following steps in the same order:

- Call Add multiplayer api to create multiple players in the game.
- System assigns each player a player id
- Player id can be found in create multiple players api response

## Apis for the game

*Adding multiple players*

`POST` 

`/v1/api/players`

`Body`: 

```
[{
    "name": "SomeName",
    "age": 12
}]
```

`Response`:
```
[{
    "playerId": "someId"
    "name": "SomeName",
    "age": 12
}]
```

*Guessing the number*

`POST`

`/v1/api/player/{playerId}/guess`

`Body`: 

```
{
    "value": 12
}
```

`Response`:

```
{
    "playerName": "Nicole",
    "age": 12,
    "status": "MORE_THAN",
    "nextPlayer": "/v1/api/player/{playerId}/guess"
}
```

*Start the game*

`GET`

`/v1/api/game?action=start`

`Response`:
```
{
    "name": "playerName"
    "api": "/v1/api/player/{playerId}/guess"
}
```


*Reset the game*

`GET`

`/v1/api/game?action=reset`

`Response`:
```
Game reset . Thank you for playing !!
```
