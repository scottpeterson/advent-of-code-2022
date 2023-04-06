class Solution {
    // construct lookup data set (constant)
    // loop through `digits` function parameter
    // for each digit, look up in Map
    // start building up a result string
    // loop through list of values for that key
    // add to result string
    // when new digit, start new result string
    // keep adding result strings to list
    // sort each string alphabetically
    // dedup strings with .distinct()

    val keypadData = mapOf(
        "2" to listOf("a", "b", "c"),
        "3" to listOf("d", "e", "f"),
        "4" to listOf("g", "h", "i"),
        "5" to listOf("j", "k", "l"),
        "6" to listOf("m", "n", "o"),
        "7" to listOf("p", "q", "r", "s"),
        "8" to listOf("t", "u", "v"),
        "9" to listOf("w", "x", "y", "z"),
    )

    fun letterCombinations(digits: String): List<String> {

        val returnList = mutableListOf<String>()

        digits.forEach { digit ->
            returnList + keypadData[digit]
        }
        return returnList
    }
}



