package com.rodrigojscript.yesido.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SaldoDia::class], version = 1, exportSchema = false)
abstract class YesDatabase : RoomDatabase() {
    abstract fun yesDao(): YesDao

    companion object {
        private var INSTANCE: YesDatabase? = null
        fun getInstance(context: Context): YesDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    YesDatabase::class.java,
                    "roomdb"
                )
                    .build()
            }
            return INSTANCE as YesDatabase
        }
    }
}