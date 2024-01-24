package com.example.mantra.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mantra.model.Mantra
import com.example.mantra.repositories.MantraRepository

class MantraViewModel(application: Application):AndroidViewModel(application) {
    private var repository: MantraRepository= MantraRepository(application)
    private var allMantraList = repository.getAllMantras()

    suspend fun insert(mantra: Mantra){
        repository.insertMantra(mantra)
    }

    suspend fun update(mantra: Mantra){
        repository.updateMantra(mantra)
    }

    suspend fun delete(mantra: Mantra){
        if (mantra.id <= 0) return
        repository.deleteMantra(mantra)
    }
    fun getAllData():LiveData<List<Mantra>>{
        return allMantraList
    }
}