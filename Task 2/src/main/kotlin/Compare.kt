/*

    Результаты на 1000
    Simple result: 4456; time: 38154
    4 CompletableFuture result: 4456; time: 27408
    Akka result: 4456; time: 19632
    RxObservable result: 4456; time: 48709

    Результаты на 2000
    Simple result: 9205; time: 63686
    4 CompletableFuture result: 9205; time: 51929
    Akka result: 9205; time: 37842
    RxObservable result: 9205; time: 92043

    Результаты на 4000
    Simple result: 18038; time: 177606
    4 CompletableFuture result: 18038; time: 223414
    Akka result: 18038; time: 109527
    RxObservable result: 18038; time: 385290
 */

fun main(args: Array<String>) {
    println(getFactorsSimple())
    println(getFactorsCompletableFuture())
    println(getFactorsAkka())
    println(getFactorsRxObservable())
}