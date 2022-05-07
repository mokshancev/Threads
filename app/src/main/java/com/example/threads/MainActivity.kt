package com.example.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.threads.synchronyzed.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TestSemaphore.newInstance().startTest()
        //TestSemaphore.newInstance().startTest2()
        //TestCountDownLatch.newInstance().startTest()
        //TestCyclicBarrier.newInstance().startTest()
        TestExchanger.newInstance().startTest()
    }
}