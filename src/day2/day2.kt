package day2

import java.io.File

fun main() {
    problem1()
    problem2()
}

fun problem2() {
    var h = 0
    var x = 0
    var aim = 0
    File("src/day2/input2.txt")
        .readLines().forEach {
            val (op, num) = it.split(" ")
            val X = num.toInt()
            when(op) {
                "up" -> {
                    aim -= X
                }
                "down" -> {
                    aim += X
                }
                "forward" -> {
                    x += X
                    h += aim * X
                }
            }
        }
    println("Problem 2: ${x * h}")
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
