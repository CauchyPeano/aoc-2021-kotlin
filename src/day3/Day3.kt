package day3

import java.io.File


fun main() {
    problem1()
    problem2()
}

fun problem2() {
    val ints = File("src/day3/input3.txt")
        .readLines()
        .map { Integer.parseInt(it, 2) }

}

fun problem1() {
    val ints = File("src/day3/input3.txt")
        .readLines()
        .map { Integer.parseInt(it, 2) }

    val arr = IntArray(12)

    for (num in ints) {
        for ((idx, _) in arr.withIndex()) {
            arr[idx] += if ((num and (1 shl idx)) > 0) 1 else 0
        }
    }

    val n = ints.count()
    var a = 0
    var b = 0
    arr.forEachIndexed { i, k ->
        val bit = if (k >= n / 2) 1 else 0
        a = a or (bit shl i)
        b = b or ((if (bit == 1) 0 else 1) shl i)
    }

    println("Problem1: ${a * b}")

}
