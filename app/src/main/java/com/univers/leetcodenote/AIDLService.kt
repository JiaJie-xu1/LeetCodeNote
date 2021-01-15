package com.univers.leetcodenote

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.univers.aidlserver.IMyAidlInterfaceImpl

class AIDLService : Service() {
    override fun onBind(p0: Intent?): IBinder {
        MainAidlAcitivity.getMainActivity()
        return MyBinder()
    }

    interface OnLoginListener {
        fun login(userName: String, password: String)
    }

    lateinit var loginListener: OnLoginListener

    fun setOnLoginListener(onLoginListener: OnLoginListener) {
        this.loginListener = onLoginListener
        //prevail
    }

    inner class MyBinder : IMyAidlInterfaceImpl() {
        override fun login(userName: String, passWord: String) {
            Log.e("xujj", "MyBinder Message from client :$userName \n password:$passWord")
            loginListener.let {
                if (userName != null && passWord != null) {
                    it.login(userName, passWord)
                }
            }
        }

        fun getService(): AIDLService {
            return this@AIDLService
        }
    }


}