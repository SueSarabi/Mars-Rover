package org.example

data class Position(val x: Int, val y: Int) {
    fun roverMovement(direction: Direction): Position = when (direction) {
        Direction.E -> copy(x = x + 1)
        Direction.S -> copy(y = y - 1)
        Direction.W -> copy(x = x - 1)
        Direction.N -> copy(y = y + 1)
    }

    override fun toString(): String = "$x $y"
}
