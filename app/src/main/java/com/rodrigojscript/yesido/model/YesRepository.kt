package com.rodrigojscript.yesido.model

import android.app.Application
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.rodrigojscript.yesido.model.database.DineroEnNotas
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.model.database.YesDao
import com.rodrigojscript.yesido.model.database.YesDatabase
import com.rodrigojscript.yesido.view.screens.*
import com.rodrigojscript.yesido.viewmodel.YesViewModel


/**
 * Yes repository: Repositorio para conectar viewmodel con model
 *
 * @constructor
 *
 * @param application
 */
class YesRepository(application: Application) {
    private var yesDao: YesDao

    init {
        val database = YesDatabase.getInstance(application)
        yesDao = database.yesDao()
    }

    val readAllSaldo: LiveData<MutableList<SaldoDia>> = yesDao.getSaldoDia()
    val readAllNotas: LiveData<MutableList<DineroEnNotas>> = yesDao.getDineroEnNotas()

    /**
     * Insert saldo
     *
     * @param saldoDia
     */
    suspend fun insertSaldo(saldoDia: SaldoDia) {
        yesDao.insert(saldoDia)
    }

    suspend fun insertNotas(dineroEnNotas: DineroEnNotas) {
        yesDao.insertN(dineroEnNotas)
    }

    /**
     * Delete saldo
     *
     * @param saldoDia
     */
    suspend fun deleteSaldo(saldoDia: SaldoDia) {
        yesDao.delete(saldoDia)
    }

    suspend fun deleteNota(dineroEnNotas: DineroEnNotas) {
        yesDao.deleteN(dineroEnNotas)
    }

    suspend fun clear() {
        yesDao.clear()
    }

    /**
     * Calcular dinero fisico ingresado
     *
     * @param numberMil
     * @param numberQui
     * @param numberDoc
     * @param numberCie
     * @param numberCin
     * @param numberVei
     * @param numberDie
     * @param numberCco
     * @param numberDos
     * @param numberUno
     * @param numberCen
     */
    fun calcularDF(
        numberMil: String,
        numberQui: String,
        numberDoc: String,
        numberCie: String,
        numberCin: String,
        numberVei: String,
        numberDie: String,
        numberCco: String,
        numberDos: String,
        numberUno: String,
        numberCen: String
    ) {
        val nMil: Double? = isNullDF(numberMil, 1000.0)
        val nQui: Double? = isNullDF(numberQui, 500.0)
        val nDoc: Double? = isNullDF(numberDoc, 200.0)
        val nCie: Double? = isNullDF(numberCie, 100.0)
        val nCin: Double? = isNullDF(numberCin, 50.0)
        val nVei: Double? = isNullDF(numberVei, 20.0)
        val nDie: Double? = isNullDF(numberDie, 10.0)
        val nCco: Double? = isNullDF(numberCco, 5.0)
        val nDos: Double? = isNullDF(numberDos, 2.0)
        val nUno: Double? = isNullDF(numberUno, 1.0)
        val nCen: Double? = isNullDF(numberCen, 0.5)
        dineroFisico =
            if (nMil != null && nQui != null && nDoc != null && nCie != null && nCin != null && nVei != null && nDie != null && nCco != null && nDos != null && nUno != null && nCen != null) {
                nMil + nQui + nDoc + nCie + nCin + nVei + nDie + nCco + nDos + nUno + nCen
            } else {
                0.0
            }
    }

    private fun isNull(input: String): Double? {
        return try {
            input.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun isNullDF(input: String, value: Double): Double? {
        return try {
            input.toDouble() * value
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    /**
     * Explicidad: Mas explicidad al resultado
     *
     * @param dineroT
     */
    fun explicidad(dineroT: Double) {
        colors = if (dineroT > 0.1) {
            Color.Green
        } else if (dineroT < 0.0) {
            Color.Red
        } else {
            Color(0xff0034e1)
        }
        explicito = if (dineroT > 0.1) {
            "Sobran"
        } else if (dineroT < 0.0) {
            "Faltan"
        } else {
            "Todo Cuadra"
        }
    }

     fun getDataForChart(list: List<SaldoDia>): ChartEntryModel {
        val lastSevenDineroTotal: List<Float> = list.takeLast(7).map { it.dineroTotal.toFloat() }
        val day1DineroTotal: Float = lastSevenDineroTotal.getOrNull(0) ?: 0f
        val day2DineroTotal: Float = lastSevenDineroTotal.getOrNull(1) ?: 0f
        val day3DineroTotal: Float = lastSevenDineroTotal.getOrNull(2) ?: 0f
        val day4DineroTotal: Float = lastSevenDineroTotal.getOrNull(3) ?: 0f
        val day5DineroTotal: Float = lastSevenDineroTotal.getOrNull(4) ?: 0f
        val day6DineroTotal: Float = lastSevenDineroTotal.getOrNull(5) ?: 0f
        val day7DineroTotal: Float = lastSevenDineroTotal.getOrNull(6) ?: 0f

        val chartEntryModel = entryModelOf(
            day1DineroTotal,
            day2DineroTotal,
            day3DineroTotal,
            day4DineroTotal,
            day5DineroTotal,
            day6DineroTotal,
            day7DineroTotal
        )

        return chartEntryModel
    }
}