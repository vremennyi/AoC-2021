/**
 * @author Ural Yulmukhametov <a href="mailto:vremennyi@rambler.ru"></a>
 * @date 02.12.2021
 */
fun main() {
    fun part1(input: List<String>): Int {
        var pos = 0
        var depth = 0
        for (s in input) {
            val parts = s.split(" ")
            if (parts.size < 2)
                continue
            when (parts.get(0)) {
                "forward" -> pos += parts.get(1).toInt()
                "down" -> depth -= parts.get(1).toInt()
                "up" ->  depth += parts.get(1).toInt()
            }
            if (depth > 0)
                depth = 0
        }
        return pos * -depth
    }

    fun part2(input: List<String>): Int {
        var pos = 0
        var depth = 0
        var aim = 0
        for (s in input) {
            val parts = s.split(" ")
            if (parts.size < 2)
                continue
            val value = parts.get(1).toInt()
            when (parts.get(0)) {
                "forward" -> {
                    pos += value
                    depth += aim * value
                }
                "down" -> aim -= value
                "up" ->  aim += value
            }
            if (depth > 0)
                depth = 0
        }
        return pos * -depth
    }

    val testInput = readInput("test_02")

    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("input_02")
    println(part1(input))
    println(part2(input))
}