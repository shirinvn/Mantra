package com.example.mantra.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mantra.dao.MantraDao
import com.example.mantra.db.MantraDataBase
import com.example.mantra.model.Mantra

class MantraRepository(application: Application) {

    private  var mantraDao: MantraDao

    private lateinit var allMantraList: LiveData<List<Mantra>>

    init {
        val database = MantraDataBase.getInstance(application)
        mantraDao= database.mantraDao()
       suspend { allMantraList= mantraDao.getAllMantras()}
    }

   suspend fun insertMantra(mantra: Mantra){
       mantraDao.insertMantra(mantra = mantra)
    }

    suspend fun updateMantra(mantra: Mantra){
        mantraDao.updateMantra(mantra = mantra)
    }
    suspend fun deleteMantra(mantra: Mantra){
        mantraDao.deleteMantra(mantra = mantra)
    }
    fun getAllMantras(): LiveData<List<Mantra>>{
        return allMantraList
    }
}