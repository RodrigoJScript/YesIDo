package com.rodrigojscript.yesido.model.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface YesDao {
    @Query("SELECT * FROM saldodia ORDER BY id DESC")
    fun getSaldoDia(): LiveData<MutableList<SaldoDia>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(saldoDia: SaldoDia)

    @Update
    suspend fun update(saldoDia: SaldoDia)

    @Delete
    suspend fun delete(saldoDia: SaldoDia)

}