package com.mdf.deklarasi.dao

import androidx.room.*
import com.mdf.deklarasi.model.ShofarSound

@Dao
interface ShofarSoundDao {

    @Query("SELECT * FROM shofarsound")
    fun getAllShofarSound(): List<ShofarSound>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shofarSounds: List<ShofarSound>)

    @Delete
    fun delete(shofarSound: ShofarSound)
}