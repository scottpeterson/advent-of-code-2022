fun main() {
    fun part1(input: List<String>): Int {
        val testInput = readInput("Day01_test")
        var map: MutableMap<Int, Int> = mutableMapOf()
        var key = 1

        testInput.forEach {
            if (it == "") {
                ++key
                return@forEach
            }

            map[key] = map[key]?.plus(it.toInt()) ?: 0.plus(it.toInt())
        }
        return map.values.maxOrNull()!!
    }

    fun part2(input: List<String>): Int {
        val testInput = readInput("Day01_test")
        var map: MutableMap<Int, Int> = mutableMapOf()
        var key = 1

        testInput.forEach {
            if (it == "") {
                ++key
                return@forEach
            }

            map[key] = map[key]?.plus(it.toInt()) ?: 0.plus(it.toInt())
        }

        val sortedValues = map.toList().sortedByDescending { (key, value) -> value }.toMap().values

        print(sortedValues.take(3).sum())

        return sortedValues.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 72240)
//
    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
