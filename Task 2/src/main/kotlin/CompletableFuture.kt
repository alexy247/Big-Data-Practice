import java.io.File
import java.math.BigInteger
import java.util.concurrent.CompletableFuture

// Расчет с помощью 4 CompletableFuture

fun getFactorsCompletableFuture() {
    val currentTime = System.currentTimeMillis()
    var sum = 0L
    val lines: List<String> = File(fileName).readLines()

    for (i in (lines.indices step 4)) {
        val f1 = CompletableFuture.supplyAsync { getCountOfFactors(BigInteger(lines[i])) }
        val f2 = CompletableFuture.supplyAsync { getCountOfFactors(BigInteger(lines[i+1])) }
        val f3 = CompletableFuture.supplyAsync { getCountOfFactors(BigInteger(lines[i+2])) }
        val f4 = CompletableFuture.supplyAsync { getCountOfFactors(BigInteger(lines[i+3])) }

        sum += f1.get() + f2.get() + f3.get() + f4.get()
    }

    val newTime = System.currentTimeMillis()
    println("4 CompletableFuture result: " + sum.toString() + "; time: " + (newTime - currentTime))
}

/*
 На 20 числах занимает (16 17 17 14 18) секунд
 */

fun main (args: Array<String>) {
    println(getFactorsCompletableFuture())
}