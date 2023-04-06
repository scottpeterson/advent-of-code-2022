fun main() {
    fun String.findDistinct() = toSet().size == length

    fun findUniqueString(input: String, length: Int) =
        input.windowed(length).indexOfFirst(String::findDistinct) + length

    fun daySixPartOne(input: String) = findUniqueString(input, 4)
    fun daySixPartTwo(input: String) = findUniqueString(input, 14)

    val result1 = daySixPartOne(readInput("day06/Day06_input").first())
    val result2 = daySixPartTwo(readInput("day06/Day06_input").first())

    println(result1)
    println(result2)

    val test = "as".findDistinct()
    println(test)
}

