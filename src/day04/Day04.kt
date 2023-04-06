private class CleaningAssignment(start: Int, end: Int) {
    val range = start..end

    infix fun containsAll(other: CleaningAssignment) = range.intersect(other.range).size == other.range.count()
    infix fun containsAny(other: CleaningAssignment) = range.intersect(other.range).isNotEmpty()

    companion object {
        fun parse(input: String) =
            input.split("-").map { id -> id.toInt() }.let { (start, end) -> CleaningAssignment(start, end) }
    }
}

private class CleaningAssignmentPair(val first: CleaningAssignment, val second: CleaningAssignment) {
    fun hasFullOverlap() = first containsAll second || second containsAll first
    fun hasAnyOverlap() = first containsAny second || second containsAny first

    companion object {
        fun parse(input: String) = input.split(",").map(CleaningAssignment::parse).let { (first, second) -> CleaningAssignmentPair(first, second) }
    }
}


fun main() {
    fun partOne(input: List<CleaningAssignmentPair>): Int = input.count { it.hasFullOverlap() }
    fun partTwo(input: List<CleaningAssignmentPair>): Int = input.count { it.hasAnyOverlap() }

    val input = readInput("day04/Day04_Input").map(CleaningAssignmentPair::parse)

    println(partOne(input))
    println(partTwo(input))


}