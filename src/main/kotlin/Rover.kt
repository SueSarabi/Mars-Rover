package org.example

class Rover {
    constructor(p: String) {
        val parts = p.split(' ')
        if (parts.size >= 3) {
            state.xx = parts[0].toInt()
            state.yy = parts[1].toInt()
            state.dd = Direction.valueOf(parts[2])
        }
    }

    fun go(commands: String) {
        for (command in commands) {
            when (command) {
                'L' -> state.dd = state.dd.left()

                'R' -> state.dd = state.dd.right()

                'M' ->
                    when (state.dd) {
                        Direction.E -> state.xx++
                        Direction.S -> state.yy--
                        Direction.W -> state.xx--
                        Direction.N -> state.yy++
                    }
            }
        }
    }

    fun g(z: Char) {
        go(z.toString())
    }

    val xyd: String
        get() = "${state.xx} ${state.yy} ${state.dd}"

    fun pos(): String = xyd

    constructor() : this("")

    private var state = RoverState()
}

class RoverState {
    var xx: Int = 0
    var yy: Int = 0
    var dd: Direction = Direction.N
}
