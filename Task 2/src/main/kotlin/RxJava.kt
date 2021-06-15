import io.reactivex.rxjava3.core.Observable
import java.io.File
import java.util.*


fun getFactorsRxObservable() {
    val currentTime = System.currentTimeMillis()
    var array = Collections.synchronizedList(mutableListOf<Long>())
    val numbers = File(fileName).readLines().map { it.toBigInteger() }

    Observable.fromIterable(numbers)
        .map { x -> getCountOfFactors(x) }
        .subscribe { x -> array.add(x) }

    val newTime = System.currentTimeMillis()
    println("RxObservable result: " + array.sum().toString() + "; time: " + (newTime - currentTime))
}

/*
 На 20 числах занимает (14 13 11 13 15) секунд
 */

fun main(args: Array<String>) {
    println(getFactorsRxObservable())
}