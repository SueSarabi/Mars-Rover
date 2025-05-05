package org.example

enum class Direction {
    N,
    E,
    S,
    W,
    ;

    fun left(): Direction =
        when (this) {
            N -> W
            W -> S
            S -> E
            E -> N
        }

    fun right(): Direction =
        when (this) {
            N -> E
            E -> S
            S -> W
            W -> N
        }
}
