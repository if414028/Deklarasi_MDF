package com.mdf.deklarasi.database

abstract class DatabaseSuccessListener<M> : Runnable {
    private var result: M? = null

    open fun getResult(): M? {
        return result
    }

    open fun setResult(result: M) {
        this.result = result
    }

    override fun run() {
        onSuccessResponse(getResult())
    }

    abstract fun onSuccessResponse(results: M?)
}