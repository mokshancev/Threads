package com.example.threads.synchronyzed

import java.util.concurrent.Semaphore

class TestSemaphore private constructor() {
    private val PARKING_SPACE = Semaphore(MAX_THREADS, IS_FAIR)

    fun startTest() {
        for (i in 0..100) {
            val thread = Thread({
                println("${Thread.currentThread().name} - Я заезжаю на парковку")
                PARKING_SPACE.acquire()
                println("${Thread.currentThread().name} - Я на парковке")
                Thread.sleep(2000)
                println("${Thread.currentThread().name} - Я уезжаю с парковки")
                PARKING_SPACE.release()
            }, "$i thread")
            thread.start()
        }
    }

    fun startTest2() { // Здесь получаем разрешение от этого семафора, только если он доступен во время вызова.
        for (i in 0..100) {
            val thread = Thread({
                println("${Thread.currentThread().name} - Я заезжаю на парковку")
                if(PARKING_SPACE.tryAcquire()){
                    println("${Thread.currentThread().name} - Я на парковке")
                    Thread.sleep(2000)
                    println("${Thread.currentThread().name} - Я уезжаю с парковки")
                    PARKING_SPACE.release()
                }
            }, "$i thread")
            thread.start()
        }
    }

    companion object {
        private const val MAX_THREADS = 3 //Максимальное количество потоков, у которых будет доступ к ресурсам
        private const val IS_FAIR = true //Будут ли потоки выполняться в той последовательности, в которой были запущены
        fun newInstance() = TestSemaphore()
    }
}