package day2

import java.io.File

fun main() {
    problem1()
}

fun problem1() {

    var h = 0
    var x = 0
    File("src/day2/input2.txt")
        .readLines().forEach {
            val (op, num) = it.split(" ")
            val n = num.toInt()
            when(op) {
                "up" -> h -= n
                "down" -> h += n
                "forward" -> x += n
            }
        }
    println("Problem 1: ${x * h}")

}
