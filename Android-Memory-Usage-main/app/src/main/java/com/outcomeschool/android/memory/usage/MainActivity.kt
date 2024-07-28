package com.outcomeschool.android.memory.usage

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val idList = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        logCurrentMemoryProfile("onCreate start")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logCurrentMemoryProfile("onCreate after setContentView")

        Thread {
            Thread.sleep(10000)
            logCurrentMemoryProfile("onCreate end after delay")
        }.start()
    }

    @CustomAnnotation(priority = CustomAnnotation.Priority.LOW)
    fun execute(view: View) {
        for (i in 1..1000000) {
            idList.add(i)
        }
        logCurrentMemoryProfile("execute current idList size : ${idList.size}")
    }

}