package day6

import java.io.File
import java.math.BigInteger

fun main() {
    val testLines = parse("src/day6/input6_test.txt")
    val inputLines = parse("src/day6/input6.txt")
    problem1(testLines, 80)
    problem1(inputLines, 80)
    problem1(testLines, 256)
    problem1(inputLines, 256)
}

val cache: MutableMap<String, BigInteger> = hashMapOf()

fun problem1(input: List<Int>, days: Int) {

    var res: BigInteger = BigInteger.ZERO
    input.forEach {
        val get = cache.get("$it:$days")
        res += if (get == null) {
            val calc = calc(it, days)
            cache.put("$it:$days", calc)
            calc
        } else {
            get
        }

    }
    println("Problem: $res for $days")

}

fun calc(fish: Int, days: Int): BigInteger {
    val cacheVal = cache.get("$fish:$days")
    if (cacheVal != null) {
        return cacheVal
    } else {
        val res = if (days == 0) BigInteger.ONE
        else when (fish) {
            0 -> calc(6, days - 1) + calc(8, days - 1)
            else -> calc(fish - 1, days - 1)
        }
        cache.put("$fish:$days", res)
        return res
    }
}

private fun parse(filename: String) = File(filename).readLines().first().split(",").map { it.toInt() }
