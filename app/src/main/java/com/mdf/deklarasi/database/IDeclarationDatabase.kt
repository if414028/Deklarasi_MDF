package com.mdf.deklarasi.database

import com.mdf.deklarasi.model.Declaration
import com.mdf.deklarasi.model.SpiritualWarfareVerse

interface IDeclarationDatabase {

    //Declaration
    fun getAllDeclaration(
        successListener: DatabaseSuccessListener<List<Declaration>>,
        errorListener: DatabaseErrorListener
    )

    fun insertDeclaration(
        declarationList: List<Declaration>,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    )

    fun deleteDeclaration(
        declaration: Declaration,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    )

    fun getDetailDeclaration(
        declarationId: String,
        successListener: DatabaseSuccessListener<Declaration>,
        errorListener: DatabaseErrorListener
    )

    fun setFavDeclaration(
        isFav: Int,
        declarationId: String,
        successListener: DatabaseSuccessListener<Boolean>,
        errorListener: DatabaseErrorListener
    )

    fun getFavDeclaration(
        successListener: DatabaseSuccessListener<List<Declaration>>,
        errorListener: DatabaseErrorListener
    )

    //Spiritual Warfare Verse
    fun getAllSpiritualWarfareVerse(
        successListener: DatabaseSuccessListener<List<SpiritualWarfareVerse>>,
        errorListener: DatabaseErrorListener
    )

    fun insertSpiritualWarfareVerse(
        spiritualWarfareVerse: List<SpiritualWarfareVerse>,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    )

    fun deleteSpiritualWarfareVerse(
        spiritualWarfareVerse: SpiritualWarfareVerse,
        successListener: DatabaseSuccessListener<Void>,
        errorListener: DatabaseErrorListener
    )
}