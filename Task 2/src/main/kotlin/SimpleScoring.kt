import java.io.File
import java.io.InputStream
import java.math.BigInteger

fun getFactorsSimple() {
    val currentTime = System.currentTimeMillis()
    var sum = 0L

    val inputStream: InputStream = File("nums.txt").inputStream()
    inputStream.bufferedReader().forEachLine { line -> sum += getCountOfFactors(BigInteger(line)) }

    val newTime = System.currentTimeMillis()
    println("Simple result: " + sum.toString() + "; time: " + (newTime - currentTime))
}

/*
 На 20 числах занимает (20 16 15 14 11) секунд
 */

fun main (args: Array<String>) {
    print(getTime(getFactorsSimple()))
}