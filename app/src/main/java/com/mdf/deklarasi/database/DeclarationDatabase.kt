package com.mdf.deklarasi.database

import android.app.Activity
import android.content.Context
import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.model.ShofarSound
import com.mdf.deklarasi.model.SpiritualWarfareVerse
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

    override fun getAllSpiritualWarfareVerse(
        successListener: DatabaseSuccessListener<List<SpiritualWarfareVerse>>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            successListener.setResult(
                database.spiritualWarfareVerseDao().getAllSpiritualWarfareVerse()
            )

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun insertSpiritualWarfareVerse(
        spiritualWarfareVerse: List<SpiritualWarfareVerse>,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.spiritualWarfareVerseDao().insert(spiritualWarfareVerse)

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun deleteSpiritualWarfareVerse(
        spiritualWarfareVerse: SpiritualWarfareVerse,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.spiritualWarfareVerseDao().delete(spiritualWarfareVerse)

            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun getAllShofarSound(
        successListener: DatabaseSuccessListener<List<ShofarSound>>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            successListener.setResult(database.shofarSoundDao().getAllShofarSound())
            currentActivity?.runOnUiThread(successListener)
        }

    }

    override fun insertShofarSound(
        shofarSound: List<ShofarSound>,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.shofarSoundDao().insert(shofarSound)
            currentActivity?.runOnUiThread(successListener)
        }
    }

    override fun deleteShofarSound(
        shofarSound: ShofarSound,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    ) {
        GlobalScope.launch {
            database.shofarSoundDao().delete(shofarSound)
            currentActivity?.runOnUiThread(successListener)
        }
    }

}