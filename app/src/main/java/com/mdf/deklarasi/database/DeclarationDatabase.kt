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

    override fun getDetailDeclaration(
        declarationId: String,
        successListener: DatabaseSuccessListener<Declaration>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            successListener.setResult(database.declarationDao().getDeclarationDetail(declarationId))

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun setFavDeclaration(
        isFav: Int,
        declarationId: String,
        successListener: DatabaseSuccessListener<Boolean>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.declarationDao().setIsFav(isFav, declarationId)
            successListener.setResult(
                database.declarationDao().getDeclarationDetail(declarationId).fav
            )

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun getFavDeclaration(
        successListener: DatabaseSuccessListener<List<Declaration>>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            successListener.setResult(database.declarationDao().getFavDeclaration())

            currentActivity?.runOnUiThread(successListener)
        }
    }
}