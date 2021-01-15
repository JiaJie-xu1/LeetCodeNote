package com.univers.aidlserver

import android.net.Proxy
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import com.univers.aidlserver.IMyAidlInterface.Companion.DESCRIPTOR
import com.univers.aidlserver.IMyAidlInterface.Companion.TRANSACTION_LOGIN

open class IMyAidlInterfaceImpl : Binder(), IMyAidlInterface {

    override fun login(userName: String, password: String) {}

    override fun asBinder(): IBinder {
        return this
    }

    init{
        this.attachInterface(this, DESCRIPTOR)
    }

    companion object{
        fun asInterface(obj: IBinder): IMyAidlInterface? {
            if (obj is IMyAidlInterface) {
                return obj
            }
            return Proxy(obj)
        }
    }

    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        val descriptor = DESCRIPTOR
        return when (code) {
            INTERFACE_TRANSACTION -> {
                super.onTransact(code, data, reply, flags)
            }
            TRANSACTION_LOGIN -> {
                data.enforceInterface(descriptor)
                val arg0 = data.readString()
                val arg1 = data.readString()
                this.login(arg0!!, arg1!!)
                reply?.readException()
                true
            }
            else -> super.onTransact(code, data, reply, flags)
        }

    }

    class Proxy(val mRemote: IBinder) : IMyAidlInterface {
        fun getInterfaceDescription(): String {
            return DESCRIPTOR
        }

        override fun login(userName: String, password: String) {
            var data: Parcel = Parcel.obtain()
            var reply: Parcel = Parcel.obtain()

            try {
                data.writeInterfaceToken(DESCRIPTOR)
                data.writeString(userName)
                data.writeString(password)

                var transact = mRemote.transact(TRANSACTION_LOGIN, data, reply, 0)

                reply.readException()
            } finally {
                data.recycle()
                reply.recycle()
            }
        }

        override fun asBinder(): IBinder {
            return mRemote
        }
    }
}