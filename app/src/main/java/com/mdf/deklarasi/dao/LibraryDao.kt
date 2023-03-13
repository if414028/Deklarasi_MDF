package com.mdf.deklarasi.dao

import androidx.room.*
import com.mdf.deklarasi.model.Library
import com.mdf.deklarasi.model.SpiritualWarfareVerse

@Dao
interface LibraryDao {

    @Query("SELECT * FROM library")
    fun getAllLibrary(): List<Library>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(libraries: List<Library>)

    @Delete
    fun delete(library: Library)

}