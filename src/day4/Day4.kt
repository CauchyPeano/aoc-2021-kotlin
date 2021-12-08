package day4

import java.io.File
import java.util.regex.Pattern

class Day4 {
}

class Board(board: List<List<Int>>) {

    fun check(num: Int): Boolean {
        if (allNums.contains(num)) {
            allNums.remove(num)
            for (i in 0 until 5)
                for (j in 0 until 5)
                    if (b[i][j] == num) b[i][j] = -1
            return true
        }
        return false
    }

    fun won(): Boolean {
        val fHorizontal = b.find { it.all { it == -1 } }
        if (fHorizontal != null) {
            return true
        }
        for (x in 0 until 5) {
            if (b.map { it.get(x) }.all { it == -1 }) return true
        }
        return false
    }

    fun score(): Int {
        return b.map { it.filter { it != -1 }.sum() }.sum()
    }

    private val allNums: MutableSet<Int> = board.flatten().toMutableSet()
    private val b: Array<IntArray> = board.map { it.toIntArray() }.toTypedArray()

}

fun main() {
    val lines = File("src/day4/input4.txt").readLines()
    val test_lines = File("src/day4/input4_test.txt").readLines()
    problem1(test_lines)
    problem1(lines)

    problem2(test_lines)
    problem2(lines)
}

fun problem1(strings: List<String>) {

    val rndNums = strings.get(0).split(",").map { it.toInt() }

    val windowed = parseBoards(strings)

    for (rnd in rndNums) {
        for ((index, board) in windowed.withIndex()) {
            if (board.check(rnd) && board.won()) {
                println("Problem1: with ${rnd} and board #${index} and total score ${board.score() * rnd}")
                return
            }
        }
    }
}

fun problem2(lines: List<String>) {
    val rndNums = lines.get(0).split(",").map { it.toInt() }

    val windowed = parseBoards(lines).toMutableList()

    var lastRnd = 0
    var lastBoard : Board = windowed.first()
    for (rnd in rndNums) {
        val iterator = windowed.iterator()
        for (board in iterator) {
            if (board.check(rnd) && board.won()) {
                iterator.remove()
                lastRnd = rnd
                lastBoard = board
            }
        }
    }
    println("Problem2: ${lastBoard.score()*lastRnd}")

}

private fun parseBoards(strings: List<String>): List<Board> {
    var windowed = strings.drop(1)
        .filter { it.isNotBlank() }
        .map { it.trim().split(regex = Pattern.compile("[\\s]+")).map { it.toInt() } }
        .windowed(5, step = 5)
        .map { Board(it) }
    return windowed
}
