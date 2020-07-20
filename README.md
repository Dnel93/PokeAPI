# PokeAPI
This is a wrapper REST service created with Spring, it is consuming PokeAPI service provided by [PokeAPI.co](https://pokeapi.co/).
The service will provide information to [PokeAPI-UI](https://github.com/Dnel93/PokeAPI-UI) a web application created with `React`.

You can start the service following the next steps:
1. Access root location of the project
2. Execute: `./gradlew bootrun`

__Note:__ By default the service initiate with `port 5000` root path as usual will be: `localhost`

## Methods avilable
PokeAPI contains only one method for now, these are the details:

| Method Type        | Path           | Parameters      | Example                             |
|:------------------ |:-------------- |:--------------- |:----------------------------------- |
| GET                | /v1/Pokemon/   | {Pokemon Name}  | localhost:5000/v1/Pokemon/Charizard   |

___Response Example___
```
{
    "id": 6,
    "name": "charizard",
    "sprites": {
        "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png",
        "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"
    },
    "types": [
        {
            "slot": 2,
            "type": {
                "name": "flying"
            }
        },
        {
            "slot": 1,
            "type": {
                "name": "fire"
            }
        }
    ]
}
```

| HTTP Status Code | Http Status Message |
|:---------------- |:------------------- |
| 200              | OK                  |


### In progress
Currently I'm working on different responses for the current endpoint and working with some others endpoints to be implemented in the future
