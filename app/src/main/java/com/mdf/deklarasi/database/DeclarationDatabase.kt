package com.mdf.deklarasi.database

import android.app.Activity
import android.content.Context
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.utilities.AppConfiguration
import com.mdf.deklarasi.utilities.DeclarationDatabaseImplementation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DeclarationDatabase(context: Context) : IDeclarationDatabase {

    private val database: DeclarationDatabaseImplementation
    private val context: Context
    private var currentActivity: Activity? = null

    init {
        this.context = context
        if (context is Activity) {
            currentActivity = context
        }

        database = AppConfiguration.getInstance().getDatabase()
    }


    override fun getAllDeclaration(
        successListener: DatabaseSuccessListener<List<Declaration>>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            val declarationList = database.declarationDao().getAllDeclaration()
            successListener.setResult(declarationList)

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun insertDeclaration(
        declarationList: List<Declaration>,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.declarationDao().insert(declarationList)

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun deleteDeclaration(
        declaration: Declaration,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.declarationDao().delete(declaration)

            currentActivity?.runOnUiThread(successListener)
        }
    }
}