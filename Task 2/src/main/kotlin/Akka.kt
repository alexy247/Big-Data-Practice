import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import akka.japi.pf.ReceiveBuilder
import java.io.File
import java.math.BigInteger

data class CountFactors(val countFactors: Long)

class MasterActor : AbstractActor() {
    var workersCount = 0
    var finished = 0
    var currentTime = 0L
    var count = 0L
    var workers = Array<ActorRef>(workersCount) {
        context.actorOf(Props.create(SlaveActor::class.java))
    }

    override fun createReceive() =
        ReceiveBuilder()
            .match(File::class.java) { file ->
                currentTime = System.currentTimeMillis()

                val numbers = file.readLines().map { BigInteger(it) }
                workersCount = numbers.size
                workers = Array(workersCount) { context.actorOf(Props.create(SlaveActor::class.java)) }

                for (i in 0 until workersCount) {
                    workers[i].tell(numbers[i], self)
                }
            }
            .match(CountFactors::class.java) {
                count += it.countFactors
                finished++
                if (finished == workersCount) {
                    val newTime = System.currentTimeMillis()
                    println("Akka result: " + count + "; time: " + (newTime - currentTime))
                    context.system.terminate()
                }
            }
            .build()!!
}

class SlaveActor : AbstractActor() {
    override fun createReceive() =
        ReceiveBuilder()
            .match(BigInteger::class.java) {
                val countFactors = getCountOfFactors(it)
                sender.tell(CountFactors(countFactors), self)}
            .build()!!
}

fun getFactorsAkka() {
    val file = File(fileName)
    val actorSystem = ActorSystem.create("AkkaAttempt")
    val actorRef = actorSystem.actorOf(Props.create(MasterActor::class.java))
    actorRef.tell(file, actorRef)
}

/*
 На 20 числах занимает (118 185 34 201 288) секунд
 */

fun main(args: Array<String>) {
    println(getFactorsAkka())
}