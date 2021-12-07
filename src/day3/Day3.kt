package day3

import java.io.File


fun main() {
    problem1()
    problem2()
}

private const val dim = 12

fun problem2() {
    val ints = File("src/day3/input3.txt")
        .readLines()
        .map { Integer.parseInt(it, 2) }

    val oxyNum = getOxyNum(ints)
    println("oxy: " + oxyNum.toString(2))

    val co2Num = getCo2Num(ints)
    println("co2: " + co2Num.toString(2))

    println("Problem2: ${co2Num * oxyNum}")
}

private fun getOxyNum(ints: List<Int>): Int {
    var oxy = ints.filter { isOxy(it) }
    for (i in (dim - 2) downTo 0) {
        if (oxy.count() == 1) return oxy.first()

        val part = oxy.partition { ((1 shl i) and it) > 0 }

        if (part.first.count() >= part.second.count()) {
            oxy = part.first
        } else {
            oxy = part.second
        }
    }
    return oxy.first()
}

private fun getCo2Num(ints: List<Int>): Int {
    var co2 = ints.filter { !isOxy(it) }
    for (i in (dim - 2) downTo 0) {
        if (co2.count() == 1) return co2.first()

        val part = co2.partition { ((1 shl i) and it) > 0 }

        if (part.first.count() < part.second.count()) {
            co2 = part.first
        } else {
            co2 = part.second
        }
    }
    return co2.first()
}

private fun isOxy(it: Int) = (1 shl (dim - 1)) and it > 0

fun problem1() {
    val ints = File("src/day3/input3.txt")
        .readLines()
        .map { Integer.parseInt(it, 2) }

    val arr = IntArray(dim)

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
