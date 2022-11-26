package com.mdf.deklarasi.database

import com.mdf.deklarasi.model.Declaration

interface IDeclarationDatabase {

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
}