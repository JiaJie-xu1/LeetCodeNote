package com.univers.canvas_view

import android.media.MediaDrm
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.univers.leetcodenote.R
import java.security.MessageDigest
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var likeView: CustomView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        likeView = findViewById(R.id.likeView)
//
        val handler: Handler = object : Handler() {
            private var degrees = 0f
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                likeView.setDegrees(5.let { degrees += it; degrees })
                sendEmptyMessageDelayed(0, 80)
            }
        }

        Log.e("xujj", "wid:${Md5Utils.getMD5String(
            getUniqueId()
        )}")
        Toast.makeText(this,"${Md5Utils.getMD5String(
            getUniqueId()
        )}",Toast.LENGTH_SHORT).show()

        handler.sendEmptyMessageDelayed(0, 20)

        Message.obtain()
    }

    /**
     * 获取设备唯一ID 新方法
     */
    fun getUniqueId(): String? {
        val WIDEVINE_UUID = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
        var wvDrm: MediaDrm? = null
        try {
            wvDrm = MediaDrm(WIDEVINE_UUID)
            val widevineId = wvDrm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)
            val md = MessageDigest.getInstance("SHA-256")
            md.update(widevineId)
            return md.digest().toHexString()
        } catch (e: Exception) {
            return null
        } finally {
            if (Build.VERSION.SDK_INT > 29) {
                wvDrm?.close()
            } else {
                wvDrm?.release()
            }
        }
    }

    fun ByteArray.toHexString() = joinToString { "%02x".format(it) }
}