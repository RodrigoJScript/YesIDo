package com.rodrigojscript.yesido.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Yes database: Aqui se instancia la base de datos
 *
 * @constructor Create empty Yes database
 */
@Database(entities = [SaldoDia::class, DineroEnNotas::class], version = 2, exportSchema = false)
abstract class YesDatabase : RoomDatabase() {
    /**
     * Yes dao: Conexion con el DAO
     *
     */
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