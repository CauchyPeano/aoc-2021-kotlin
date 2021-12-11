package day5

import java.io.File

fun main() {
    val input = File("src/day5/input5.txt").readLines()
    val inputTest = File("src/day5/input5_test.txt").readLines()
    problem1(inputTest)
    problem1(input)
    problem2(inputTest)
    problem2(input)
}

fun problem1(lines: List<String>) {
    val set1 = hashSetOf<String>()
    val set2 = hashSetOf<String>()

    val coords = lines.map { it.split(" -> ", ",").map { it.toInt() } }
    coords.forEach {
        val (x1, y1, x2, y2) = it
        if (x1 == x2) {
            val intRange = if (y1 < y2) y1..y2 else y2..y1
            for (i in intRange) {
                val key = "$x1:$i"
                if (!set1.add(key)) set2.add(key)
            }
        } else if (y1 == y2) {
            val intRange = if (x1 < x2) x1..x2 else x2..x1
            for (i in intRange) {
                val key = "$i:$y1"
                if (!set1.add(key)) set2.add(key)
            }
        }
    }

    println("Problem 1: ${set2.size}")
}

fun problem2(lines: List<String>) {

    val set1 = hashSetOf<String>()
    val set2 = hashSetOf<String>()

    val coords = lines.map { it.split(" -> ", ",").map { it.toInt() } }
    coords.forEach {
        val (x1, y1, x2, y2) = it
        if (x1 == x2) {
            val intRange = if (y1 < y2) y1..y2 else y2..y1
            for (i in intRange) {
                val key = "$x1:$i"
                if (!set1.add(key)) set2.add(key)
            }
        } else if (y1 == y2) {
            val intRange = if (x1 < x2) x1..x2 else x2..x1
            for (i in intRange) {
                val key = "$i:$y1"
                if (!set1.add(key)) set2.add(key)
            }
        } else {
            val intRangeX = if (x1 < x2) x1..x2 else x1 downTo x2
            val intRangeY = if (y1 < y2) y1..y2 else y1 downTo y2
            assert(intRangeX.count() == intRangeY.count())
            for ((i, j) in intRangeX.zip(intRangeY)) {
                val key = "$i:$j"
                if (!set1.add(key)) set2.add(key)
            }
        }
    }

    println("Problem 1: ${set2.size}")
}
