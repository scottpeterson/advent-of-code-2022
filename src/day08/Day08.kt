package day08

import readInput

// take the input of lines of strings, put into lines, put into chars, convert to Ints
private fun constructForest(input: List<String>): List<List<Int>> {
    return input.map { line ->
        line.toCharArray().map { Integer.parseInt("$it") }
    }
}

// for each "tree", calculate if it's visible at all
private fun canISee(forest: List<List<Int>>, row: Int, column: Int): Boolean {
    val treeHeight = forest[row][column]

    val visibleFromTop = forest.map { it[column] }.subList(0, row).max() < treeHeight
    val visibleFromEnd = forest[row].subList(column+1, forest[row].size).max() < treeHeight
    val visibleFromBottom = forest.map { it[column] }.subList(row + 1, forest.map { it[column] }.size).max() < treeHeight
    val visibleFromStart = forest[row].subList(0, column).max() < treeHeight

    return visibleFromTop || visibleFromEnd || visibleFromBottom || visibleFromStart
}

private fun optimalTree(forest: List<List<Int>>, row: Int, column: Int): Int {
    val treeHeight = forest[row][column]

    var distanceToStart = 0
    for (i in column - 1 downTo 0 ) {
        ++distanceToStart

        if (treeHeight <= forest[row][i]) {
            break
        }
    }

    var distanceToEnd = 0
    for (i in column + 1 until forest[row].size) {
        ++distanceToEnd

        if (treeHeight <= forest[row][i]) {
            break
        }
    }

    var distanceToTop = 0
    for (i in row - 1 downTo 0) {
        distanceToTop += 1

        if (treeHeight <= forest[i][column]) {
            break
        }
    }

    var distanceToBottom = 0
    for (i in row + 1 until forest.size) {
        distanceToBottom += 1

        if (treeHeight <= forest[i][column]) {
            break
        }
    }
    return distanceToStart * distanceToEnd * distanceToTop * distanceToBottom
}

fun partOne(input: List<String>): Int {
    val forest = constructForest(input)
    var countVisible = input.first().length * 2 + (input.size - 2) * 2
    for (i in 1..forest.first().size - 2) {
        for (j in 1..forest[i].size - 2) {
            if (canISee(forest, i, j)) {
                ++countVisible
            }
        }
    }
    return countVisible
}

fun partTwo(input: List<String>): Int {
    val forest = constructForest(input)
    var runningLargest = 0
    forest.forEachIndexed { i, row ->
        row.forEachIndexed { j, I ->
            val viewingDistance = optimalTree(forest, i, j)
            if (viewingDistance > runningLargest) {
                runningLargest = viewingDistance
            }
        }
    }
    return runningLargest
}



fun main() {
    println(partOne((readInput("day08/Day08_input"))))
    println(partTwo((readInput("day08/Day08_input"))))


}