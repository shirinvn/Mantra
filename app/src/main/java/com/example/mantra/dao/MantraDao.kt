package com.example.mantra.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mantra.model.Mantra


@Dao
interface MantraDao {

    @Insert
    fun insertMantra(mantra: Mantra)


    @Update
    fun updateMantra(mantra: Mantra)

    @Delete
    fun deleteMantra(mantra: Mantra)


    @Query("SELECT * FROM mantra order by id asc")
    fun getAllMantras(): LiveData<List<Mantra>>
}