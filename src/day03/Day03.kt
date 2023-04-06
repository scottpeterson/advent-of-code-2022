fun Char.toValue() = if (code <= 'Z'.code) this - 'A' + 27 else this - 'a' + 1

fun partOne(input: List<String>): Int {
    val result = input
        .map { rucksack -> rucksack.chunked(rucksack.length / 2) }
        .map { (compartment1, compartment2) -> compartment1.first { it in compartment2 } }
        .sumOf { it.toValue() }
    print(result)
    return result
}

fun partTwo(input: List<String>): Int {
    val result = input
        .chunked(3)
        .map { (sack1, sack2, sack3) -> sack1.first { it in sack2 && it in sack3 } }
        .sumOf { it.toValue() }
    print(result)
    return result
}

fun main() {
    partOne(readInput("day03/Day03_input"))
    partTwo(readInput("day03/Day03_input"))
}