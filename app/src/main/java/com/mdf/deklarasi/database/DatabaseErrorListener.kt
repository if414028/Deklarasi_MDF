package com.mdf.deklarasi.database

abstract class DatabaseErrorListener : Runnable {
    override fun run() {}
    abstract fun onErrorResponseListener()
}