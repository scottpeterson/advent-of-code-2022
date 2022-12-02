fun main() {
    data class Elf(
        val calories: List<Int>
    ) {
        val totalCalories: Int get() = calories.sum()
    }

    fun constructElves(input: List<String>): List<Elf> {
        val elves = mutableListOf<Elf>()

        var dynamicCalorieList = mutableListOf<Int>()

        input.forEach {string ->
            if (string.isEmpty()) {
                elves.add(Elf(dynamicCalorieList))
                dynamicCalorieList = mutableListOf()
            } else {
                dynamicCalorieList.add(string.toInt())
            }
        }
        elves.add(Elf(dynamicCalorieList))

        return elves
    }

    val elvesInput = readInput("Day01_test")
    val elves = constructElves(elvesInput)

    val sortedElves = elves
        .mapIndexed { index, elf -> index to elf}
        .sortedByDescending { (_, elf) -> elf.totalCalories }

    println("Day 1, Part 1 Solution: Elf: ${sortedElves.first().first}; Total Calories: ${sortedElves.first().second.totalCalories}")

    val topThreeElves = sortedElves
        .subList(0, 3)
        .sumOf{ (_, elf) -> elf.totalCalories}

    println("Day 1, Part 2, Solution: Total 3 in Calories: $topThreeElves")
}
