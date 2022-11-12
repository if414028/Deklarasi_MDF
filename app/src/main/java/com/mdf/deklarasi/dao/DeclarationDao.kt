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

    @Insert(onConflict = REPLACE)
    fun insert(declaration: List<Declaration>)

    @Delete
    fun delete(declaration: Declaration)
}