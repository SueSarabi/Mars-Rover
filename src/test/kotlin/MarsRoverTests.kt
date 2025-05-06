import org.example.Position
import org.example.Rover
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MarsRoverTests(
    private val startingPosition: String,
    private val instructions: String,
    private val expectedOutput: String,
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> =
            listOf(
                arrayOf("1 2 N", "", "1 2 N"),
                arrayOf("1 2 N", "L", "1 2 W"),
                arrayOf("1 2 W", "L", "1 2 S"),
                arrayOf("1 2 S", "L", "1 2 E"),
                arrayOf("1 2 E", "L", "1 2 N"),
                arrayOf("1 2 N", "R", "1 2 E"),
                arrayOf("1 2 E", "R", "1 2 S"),
                arrayOf("1 2 S", "R", "1 2 W"),
                arrayOf("1 2 W", "R", "1 2 N"),
                arrayOf("1 2 N", "M", "1 3 N"),
                arrayOf("1 2 E", "M", "2 2 E"),
                arrayOf("1 2 S", "M", "1 1 S"),
                arrayOf("1 2 W", "M", "0 2 W"),
                arrayOf("1 2 N", "LMLMLMLMM", "1 3 N"),
                arrayOf("3 3 E", "MMRMMRMRRM", "5 1 E"),
            )
    }

    @Test
    fun `execute commands`() {
        val rover = Rover(startingPosition)
        rover.go(instructions)
        assertEquals(expectedOutput, rover.showPosition())
    }

    @Test
    fun `access x and y values`() {
        val position = Position(3, 5)
        assertEquals(3, position.x)
        assertEquals(5, position.y)
    }

    @Test
    fun `handles input with missing position parts`() {
        val rover = Rover("1 2")
        assertEquals("0 0 N", rover.showPosition())
    }

    @Test
    fun `ignores invalid command`() {
        val rover = Rover("1 2 N")
        rover.go("X")
        assertEquals("1 2 N", rover.showPosition())
    }
}
