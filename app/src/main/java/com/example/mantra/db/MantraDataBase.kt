package com.example.mantra.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mantra.dao.MantraDao
import com.example.mantra.model.Mantra


@Database(entities = [Mantra::class], version = 1)
abstract class MantraDataBase : RoomDatabase() {
abstract fun mantraDao(): MantraDao

    companion object{
        private  var  instance: MantraDataBase? =null
         fun getInstance(context: Context): MantraDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    MantraDataBase::class.java, "mantra.db"
                ).fallbackToDestructiveMigration().build()

            }
            return instance as MantraDataBase

        }
    }


}