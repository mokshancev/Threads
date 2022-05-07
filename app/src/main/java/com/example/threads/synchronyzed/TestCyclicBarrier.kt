package com.example.threads.synchronyzed

import java.util.concurrent.CyclicBarrier

class TestCyclicBarrier private constructor(){
    private val WAITING_FOR_RACE = CyclicBarrier(CARS){
        Thread.sleep(1000)
        println("Все $CARS машин переправлено паромом на другую сторону")
    }

    fun startTest() {
        for (i in 0 until 100) {
            val thread = Thread({
                println("$i Я приехал на левую сторону, хочу перебраться на правую")
                WAITING_FOR_RACE.await()
            }, "$i thread")
            thread.start()
        }
    }

    companion object{
        private const val CARS = 5

        fun newInstance() = TestCyclicBarrier()
    }
}