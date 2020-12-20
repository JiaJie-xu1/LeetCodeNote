package com.univers.leetcodenote

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var likeView: LikeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        likeView = findViewById(R.id.likeView)

        val handler: Handler = object : Handler() {
            private var degrees = 0f
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                likeView.setDegrees(5.let { degrees += it; degrees })
                sendEmptyMessageDelayed(0, 80)
            }
        }

        handler.sendEmptyMessageDelayed(0, 20)
    }
}