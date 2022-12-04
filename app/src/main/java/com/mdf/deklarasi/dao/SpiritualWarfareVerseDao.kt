package com.mdf.deklarasi.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mdf.deklarasi.model.SpiritualWarfareVerse

@Dao
interface SpiritualWarfareVerseDao {

    @Query("SELECT * FROM spiritualwarfareverse")
    fun getAllSpiritualWarfareVerse(): List<SpiritualWarfareVerse>

    @Insert(onConflict = REPLACE)
    fun insert(spiritualWarfareVerse: List<SpiritualWarfareVerse>)

    @Delete
    fun delete(spiritualWarfareVerse: SpiritualWarfareVerse)

}