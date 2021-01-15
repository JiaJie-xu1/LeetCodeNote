package com.univers.leetcodenote

import android.database.Cursor

/**
 * Created by Jay.Xu
 * @since 2020/12/6
 */
fun main(){
    threadtest()
}
fun threadtest(){
    var threadLocal : ThreadLocal<String> = ThreadLocal()
    threadLocal.run {
        set("java")
    }
    System.out.println(threadLocal.get()+"   "+Thread.currentThread())
    Thread{
        threadLocal.set("Android")
        System.out.println(threadLocal.get()+"   "+Thread.currentThread())
    }.start();
    System.out.println(threadLocal.get()+"   "+Thread.currentThread())
    Thread{
        threadLocal.set("flutter")
        System.out.println(threadLocal.get()+"   "+Thread.currentThread())
    }.start();
}

fun main2(){
    val cursor : Cursor? = null

    cursor?.use {
        it.moveToNext()
        var columnNames = it.columnNames
    }
}