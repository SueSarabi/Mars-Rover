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

    private fun processCommand(command: Char) {
        when (command) {
            'L' -> state.direction = state.direction.left()

            'R' -> state.direction = state.direction.right()

            'M' -> state.moveForward()
        }
    }

    fun go(commands: String) {
        for (command in commands) {
            processCommand(command)
        }
    }

    val positionString: String
        get() = "${state.position} ${state.direction}"

    fun showPosition(): String = positionString

    private var state = RoverState()
}

class RoverState {
    var position: Position = Position(0, 0)
    var direction: Direction = Direction.N
    fun moveForward() {
        position = position.roverMovement(direction)
    }
}
