package com.univers.aidlserver

import android.os.IBinder
import android.os.IInterface

interface IMyAidlInterface : IInterface {
    companion object {
        //唯一标识 用于注册Binder
        const val DESCRIPTOR: String = "com.univers.aidlserver.IMyAidlInterface"
        //login方法的唯一标识
        const val TRANSACTION_LOGIN: Int = IBinder.FIRST_CALL_TRANSACTION + 0
    }

    fun login(userName: String, password: String)
}