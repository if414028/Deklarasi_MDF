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
}