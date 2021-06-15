import java.math.BigInteger
import java.util.*

// Количество множителей
fun getCountOfFactors(bigInteger: BigInteger): Long {
    var list = 0L
    var iter = bigInteger
    var n = BigInteger.TWO

    if (iter < n) {
        return 0
    }

    while (iter.mod(n) == BigInteger.ZERO) {
        list += 1
        iter = iter.divide(n)
    }

    var t = n.add(BigInteger.ONE)

    if (iter > BigInteger.ONE) {
        while (t.multiply(t) <= iter) {
            if (iter.mod(t).equals(BigInteger.ZERO)) {
                list += 1
                iter = iter.divide(t)
            } else {
                t = t.add(BigInteger.TWO)
            }
        }
        list += 1
    }

    return list
}

fun getTime(function: Unit): Long {
    val currentTime = System.currentTimeMillis()
    println("getTime currentTime" + currentTime)

    function

    val newTime = System.currentTimeMillis()

    println("getTime newTime " + newTime)

    return newTime - currentTime
}

fun main() {
    println(getCountOfFactors(BigInteger("241379677618439")))
}