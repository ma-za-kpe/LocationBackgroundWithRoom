package com.maku.testapp.db

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocationDao {
    @Query("SELECT * from word_table ORDER BY latitude ASC")
    fun getAlphabetizedWords(): LiveData<List<Locationstuff>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Locationstuff)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}