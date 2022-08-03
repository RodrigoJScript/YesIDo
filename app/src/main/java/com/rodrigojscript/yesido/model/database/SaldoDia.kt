package com.rodrigojscript.yesido.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Saldo dia Entidad
 *
 * @property id
 * @property dineroNotas
 * @property dineroFisico
 * @property dineroTotal
 * @property fecha
 * @constructor Create empty Saldo dia
 */
@Entity(tableName = "saldodia")
data class SaldoDia(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "notas")
    var dineroNotas: Double,

    @ColumnInfo(name = "fisico")
    var dineroFisico: Double,

    @ColumnInfo(name = "total")
    var dineroTotal: Double,

    @ColumnInfo(name = "fecha")
    var fecha: String,
)