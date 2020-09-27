package com.maku.testapp.db

import android.location.Location
import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: LocationDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Locationstuff>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Locationstuff?) {
        word?.let { wordDao.insert(it) }
    }

    suspend fun delete() {
        wordDao.deleteAll()
    }
}