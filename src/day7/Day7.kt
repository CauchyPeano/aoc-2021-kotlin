package day7

import java.io.File
import kotlin.math.roundToInt

fun main() {
    val input = parse("src/day7/input7.txt")
    val inputTest = parse("src/day7/input7_test.txt")
    problem1(inputTest)
    problem1(input)
    problem2(inputTest)
    problem2(input)
}

private fun parse(fileName: String) = File(fileName).readLines().first().split(",").map { it.toInt() }

fun problem1(ints: List<Int>) {
    val av = ints.average().roundToInt()
    val median = median(ints.toMutableList())

    val sum = ints.map { Math.abs(it - median) }.sum()

    println("Solution 1: $sum")
}

fun median(array: MutableList<Int>): Int {
    array.sort()

    if (array.size % 2 == 0) {
        return ((array[array.size / 2] + array[array.size / 2 - 1]) / 2)
    } else {
        return array[array.size / 2]
    }
}

fun problem2(ints: List<Int>) {
    val av = ints.average().roundToInt()
    var res = Integer.MAX_VALUE
    var d = 0
    for (i in 0..1840) {
        val sum = ints.map { Math.abs(it - i) }.map { (it * (it + 1)) / 2 }.sum()
        if (sum < res) {
            res = sum
            d = i
        }
    }

    println("Solution 2: $res, d = $d ")
}

