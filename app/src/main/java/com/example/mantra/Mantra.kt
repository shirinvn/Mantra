package com.example.mantra

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.launch


@Entity(tableName = "mantra_table")
data class Mantra(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val categoryId: Int
)

class MantraViewModel(private val repository: MantraRepository) : ViewModel() {

    val allMantras: LiveData<List<Mantra>> = repository.allMantras.asLiveData()



}

