package org.example

class Rover {
    constructor(p: String) {
        val parts = p.split(' ')
        if (parts.size >= 3) {
            val x = parts[0].toInt()
            val y = parts[1].toInt()
            state.position = Position(x, y)
            state.direction = Direction.valueOf(parts[2])
        }
    }

    fun go(commands: String) {
        for (command in commands) {
            when (command) {
                'L' -> state.direction = state.direction.left()

                'R' -> state.direction = state.direction.right()

                'M' -> state.moveForward()
            }
        }
    }

    fun g(z: Char) {
        go(z.toString())
    }

    val positionString: String
        get() = "${state.position} ${state.direction}"

    fun pos(): String = positionString

    constructor() : this("")

    private var state = RoverState()
}


class RoverState {
    var position: Position = Position(0, 0)
    var direction: Direction = Direction.N
    fun moveForward() {
        position = position.roverMovement(direction)
    }
}
