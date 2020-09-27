package com.maku.testapp.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.maku.testapp.db.Locationstuff
import com.maku.testapp.db.WordRepository
import com.maku.testapp.db.WordRoomDatabase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<Locationstuff>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    suspend fun insert(word: Locationstuff)  {
        repository.insert(word)
    }

    /**
     * Launching a new coroutine to delete the data in a non-blocking way
     */
    suspend fun delete(){
        repository.delete()
    }
}