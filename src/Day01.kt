import java.util.LinkedList
import java.util.Queue

fun main() {
    fun part1(input: List<String>): Int {
        var prev = Int.MAX_VALUE
        var count = 0
        for (s in input) {
            s.toIntOrNull()?.let {
                if (prev < it)
                    count++
                prev = it
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val nums: Queue<Int> = LinkedList()
        var prevSum = Int.MAX_VALUE
        var count = 0
        for (s in input) {
            val currSum = nums.sum()
            if (prevSum < currSum)
                count++

            s.toIntOrNull()?.let {
                nums.add(it)
            }

            if (nums.size < 4)
                continue

            prevSum = currSum
            nums.poll()
        }
        if (prevSum < nums.sum())
            count++

        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("test_01")

    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("input_01")
    println(part1(input))
    println(part2(input))
}
