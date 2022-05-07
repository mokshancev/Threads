package com.example.threads.synchronyzed

import java.util.concurrent.CountDownLatch
import kotlin.random.Random
import kotlin.random.nextInt

class TestCountDownLatch private constructor(){
    private val WAITING_FOR_RACE = CountDownLatch(CARS)
    fun startTest() {
        for (i in 0 until CARS) {
            val thread = Thread({
                Thread.sleep(Random.nextInt(0..5000).toLong())
                println("${Thread.currentThread().name} - На старт!")
                WAITING_FOR_RACE.countDown()
                WAITING_FOR_RACE.await()
                println("${Thread.currentThread().name} - Марш!")
            }, "$i thread")
            thread.start()
        }
    }

    companion object{
        private const val CARS = 5

        fun newInstance() = TestCountDownLatch()
    }
}