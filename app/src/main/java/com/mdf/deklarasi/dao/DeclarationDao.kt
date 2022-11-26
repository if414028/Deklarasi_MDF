package com.mdf.deklarasi.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mdf.deklarasi.model.Declaration

@Dao
interface DeclarationDao {
    @Query("SELECT * FROM declaration")
    fun getAllDeclaration(): List<Declaration>

    @Query("SELECT * FROM declaration WHERE declaration.id = :declarationId")
    fun getDeclarationDetail(declarationId: String): Declaration

    @Query("UPDATE Declaration SET fav = :isFav WHERE declaration.id = :declarationId")
    fun setIsFav(isFav: Int, declarationId: String)

    @Query("SELECT * FROM declaration WHERE fav = 1")
    fun getFavDeclaration(): List<Declaration>

    @Insert(onConflict = REPLACE)
    fun insert(declaration: List<Declaration>)

    @Delete
    fun delete(declaration: Declaration)
}