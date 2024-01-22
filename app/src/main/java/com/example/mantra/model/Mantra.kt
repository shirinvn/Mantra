package com.example.mantra.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Mantra (
    @PrimaryKey val id: Int,
    val mantra: String,
    val group: String,
    val fav: Boolean
)