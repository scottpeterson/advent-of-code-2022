enum class Opponent {
    A,
    B,
    C
}

enum class You {
    X,
    Y,
    Z
}

data class Round(
    val opponent: Opponent,
    val you: You
)

fun main() {

    fun result(opponent: Opponent, you: You): Int {
        return when (opponent) {
            Opponent.A -> when (you) {
                You.X -> 3
                You.Y -> 6
                You.Z -> 0
            }

            Opponent.B -> when (you) {
                You.X -> 0
                You.Y -> 3
                You.Z -> 6
            }

            Opponent.C -> when (you) {
                You.X -> 6
                You.Y -> 0
                You.Z -> 3
            }
        }
    }

    fun yourPlayPartTwo(opponent: Opponent, you: You): You {
        return when (opponent) {
            Opponent.A -> when (you) {
                You.X -> You.Z
                You.Y -> You.X
                You.Z -> You.Y
            }

            Opponent.B -> when (you) {
                You.X -> You.X
                You.Y -> You.Y
                You.Z -> You.Z
            }

            Opponent.C -> when (you) {
                You.X -> You.Y
                You.Y -> You.Z
                You.Z -> You.X
            }
        }
    }

    fun roundScore(result: Int, you: You): Int {
        return result + when (you) {
            You.X -> 1
            You.Y -> 2
            You.Z -> 3
        }
    }


    val input = readInput("Day02_input")
    val newDataStructure = input.map {
        Round(
            opponent = Opponent.valueOf(it.substring(0, 1)),
            you = You.valueOf(it.substring(2, 3))
        )
    }
    var total: Int = 0
    val roundResult = newDataStructure.forEach { round ->
        val result = result(round.opponent, round.you)
        val score = roundScore(result, round.you)
        total += score
    }

    val partTwoData = input.map {
        Round(
            opponent = Opponent.valueOf(it.substring(0, 1)),
            you = yourPlayPartTwo(Opponent.valueOf(it.substring(0, 1)), You.valueOf(it.substring(2, 3)))
        )
    }
    var partTwoTotal: Int = 0
    val roundResultPartTwo = partTwoData.forEach { round ->
        val result = result(round.opponent, round.you)
        val score = roundScore(result, round.you)
        partTwoTotal += score
    }
    println(partTwoTotal)
}


