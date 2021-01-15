package com.univers.lib.leetCode

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main2() {
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("Hello,")

    runBlocking {
        delay(2000L)
    }
}

//fun main() = runBlocking<Unit> {
//    GlobalScope.launch {
//        delay(1000L)
//        println("world")
//    }
//    println("Hello,")
//    delay(2000L)
//}

fun main1() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job:I am sleeping $i ...")
            delay(500L)
        }
    }

    delay(3000)
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}

fun main() = runBlocking {

    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

//rubber endow
suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // 假设我们在这里做了一些有用的事
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // 假设我们在这里也做了一些有用的事
    return 29
}


