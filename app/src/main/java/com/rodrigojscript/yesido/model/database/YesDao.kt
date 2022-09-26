package com.rodrigojscript.yesido.model.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Yes dao: maneja la conexión con la fuente de datos para obtener y almacenar datos.
 *
 * @constructor Create empty Yes dao
 */
@Dao
interface YesDao {
    /**
     * obtiene todos los objetos saldo dia
     *
     * @return
     */
    @Query("SELECT * FROM saldodia ORDER BY id DESC")
    fun getSaldoDia(): LiveData<MutableList<SaldoDia>>

    @Query("SELECT * FROM dineroennotas ORDER BY id DESC")
    fun getDineroEnNotas(): LiveData<MutableList<DineroEnNotas>>

    @Query("DELETE FROM dineroennotas")
    suspend fun clear()

    /**
     * Inserta nuevos objetos a la BD
     *
     * @param saldoDia
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(saldoDia: SaldoDia)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertN(dineroEnNotas: DineroEnNotas)

    /**
     * Update: Actualiza los objetos ya existentes en la BD
     *
     * @param saldoDia
     */
    @Update
    suspend fun update(saldoDia: SaldoDia)

    /**
     * Delete: Borra los objetos de la BD
     *
     * @param saldoDia
     */
    @Delete
    suspend fun delete(saldoDia: SaldoDia)

    @Delete
    suspend fun deleteN(dineroEnNotas: DineroEnNotas)
}