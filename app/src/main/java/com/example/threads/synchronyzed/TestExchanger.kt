package com.example.threads.synchronyzed

import java.util.concurrent.Exchanger

class TestExchanger private constructor() {
    private val EXCHANGER = Exchanger<Int>()

    fun startTest() {
        val runnable1 = Runnable {
            println("first runnable ${EXCHANGER.exchange(100)}")
        }

        val runnable2 = Runnable {
            println("second runnable ${EXCHANGER.exchange(50)}")
        }

        val thread1 = Thread(runnable1, "threadFirst")

        val thread2 = Thread(runnable2, "threadSecond")

        thread1.start()
        thread2.start()
    }

    companion object {
        fun newInstance() = TestExchanger()
    }
}