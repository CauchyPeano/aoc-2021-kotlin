import java.io.File

fun main(args: Array<String>) {
    problem1()
    problem2()
}

fun problem2() {

    val lines = File("src/day1/input1.txt").readLines()
    var cnt = 0
    var prev = 0
    lines.map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .forEachIndexed { index, i ->
            if (index > 0 && i > prev) {
                cnt++
            }
            prev = i
        }
    println("Problem 2: $cnt")

}

private fun problem1() {
    var cnt = 0
    var prev = -1
    val lines = File("src/day1/input1.txt").readLines()
    lines.forEachIndexed { index, it ->
        val num = it.toInt()
        if (index > 0 && num > prev) {
            cnt++
        }
        prev = num
    }
    println("Problem 1: $cnt")
}