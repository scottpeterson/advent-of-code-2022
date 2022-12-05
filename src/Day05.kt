fun main() {

    data class Move(val count: Int, val from: Int, val to: Int)

    fun parseInput(stringInput: List<String>): Pair<List<MutableList<Char>>, List<Move>> {
        val blankLineIndex = stringInput.indexOfFirst(String::isBlank)

        val crateCount = stringInput[blankLineIndex - 1]
            .last(Char::isDigit)
            .digitToInt()
        val crates = List(size = crateCount) { mutableListOf<Char>() }
        stringInput.subList(0, blankLineIndex - 1).asReversed().forEach { line ->
            line.chunked(4).forEachIndexed { index, content ->
                content[1].takeIf(Char::isLetter)?.let(crates[index]::plusAssign)
            }
        }

        val moves = stringInput.subList(blankLineIndex + 1, stringInput.size)
            .map {
                val split = it.split(" ")
                Move(split[1].toInt(), split[3].toInt() - 1, split[5].toInt() - 1)
            }

        return Pair(crates, moves)
    }

    fun tops(crates: List<MutableList<Char>>) =
        crates.map(List<Char>::last).joinToString(separator = "")

    fun partOne(stringInput: List<String>): String {
        val (crates, moves) = parseInput(stringInput)

        moves.forEach { move ->
            repeat(move.count) {
                crates[move.to] += crates[move.from].removeLast()
            }
        }

        println(tops(crates))
        return tops(crates)
    }

    fun <T> MutableList<T>.removeLast(count: Int): List<T> {
        val removeIndex = this.size - count
        return List(size = count) { this.removeAt(removeIndex) }
    }

    fun partTwo(stringInput: List<String>): String {
        val (crates, moves) = parseInput(stringInput)

        moves.forEach { move ->
            crates[move.to] += crates[move.from].removeLast(move.count)
        }

        println(tops(crates))
        return tops(crates)

    }

    partOne(readInput("Day05_input"))
    partTwo(readInput("Day05_input"))
}