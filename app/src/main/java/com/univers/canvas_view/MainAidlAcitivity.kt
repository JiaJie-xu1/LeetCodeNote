package com.univers.canvas_view

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.view.View
import com.univers.leetcodenote.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainAidlAcitivity : Activity(),
    AIDLService.OnLoginListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var intent = Intent(this, AIDLService::class.java)
        bindService(intent, mAIDLConnection, Context.BIND_AUTO_CREATE)
        henCoderView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    private val mAIDLConnection = object : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected (componentName: ComponentName?, iBinder: IBinder?) {
            var binder: AIDLService.MyBinder = iBinder as AIDLService.MyBinder
            var aidlService = binder.getService()
            aidlService.setOnLoginListener(this@MainAidlAcitivity)
        }

    }

    var mHandler = Handler()

    override fun login(userName: String, password: String) {
        Log.e("xujj", "Message from client :$userName \n password:$password")
//        mHandler.post {
//            tvTestAidl.text = "Message from client :$userName \n password:$password"
//        }
    }

    companion object {
        var activity: MainAidlAcitivity? = null
        fun getMainActivity(): MainAidlAcitivity {
            if (activity == null) {
                synchronized(MainAidlAcitivity::class.java) {
                    activity =
                        MainAidlAcitivity()
                }
            }
            return activity!!
        }
    }
}