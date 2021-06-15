import java.io.File
import java.math.BigInteger
import java.util.*


/*
 * Нужно сгенерировать файл, содержащий 2000 48-битных случайных целых чисел,
 * каждое число на отдельной строке.
 */

const val fileName = "nums.txt"

fun main (args: Array<String>) {
    val random = Random()
    val nums = arrayListOf<BigInteger>()
    for (i in (0..3999)) {
        nums.add(BigInteger(48, random))
    }
    File(fileName).writeText(nums.joinToString("\n"))
}
