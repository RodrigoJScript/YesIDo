package com.rodrigojscript.yesido.model

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.model.database.YesDao
import com.rodrigojscript.yesido.model.database.YesDatabase
import com.rodrigojscript.yesido.view.screens.*

class YesRepository(application: Application) {
    private var yesDao: YesDao


    init {
        val database = YesDatabase.getInstance(application)
        yesDao = database.yesDao()
    }

    val readAllSaldo: LiveData<MutableList<SaldoDia>> = yesDao.getSaldoDia()
    suspend fun insertSaldo(saldoDia: SaldoDia) {
        yesDao.insert(saldoDia)
    }

    suspend fun deleteSaldo(saldoDia: SaldoDia) {
        yesDao.delete(saldoDia)
    }

    fun calcularDN(
        nota1: String,
        nota2: String,
        nota3: String,
        nota4: String,
        nota5: String,
        nota6: String,
        nota7: String,
        nota8: String,
        nota9: String,
        nota10: String,
        nota11: String,
        nota12: String,
        nota13: String,
        nota14: String,
        nota15: String
    ) {
        val no1: Double? = isNull(nota1)
        val no2: Double? = isNull(nota2)
        val no3: Double? = isNull(nota3)
        val no4: Double? = isNull(nota4)
        val no5: Double? = isNull(nota5)
        val no6: Double? = isNull(nota6)
        val no7: Double? = isNull(nota7)
        val no8: Double? = isNull(nota8)
        val no9: Double? = isNull(nota9)
        val no10: Double? = isNull(nota10)
        val no11: Double? = isNull(nota11)
        val no12: Double? = isNull(nota12)
        val no13: Double? = isNull(nota13)
        val no14: Double? = isNull(nota14)
        val no15: Double? = isNull(nota15)

        dineroNotas =
            if (no1 != null && no2 != null && no3 != null && no4 != null && no5 != null && no6 != null && no7 != null && no8 != null && no9 != null && no10 != null && no11 != null && no12 != null && no13 != null && no14 != null && no15 != null) {
                no1 + no2 + no3 + no4 + no5 + no6 + no7 + no8 + no9 + no10 + no11 + no12 + no13 + no14 + no15
            } else {
                0.0
            }
    }

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

    fun explicidad(dineroT: Double) {
        colors = if (dineroT > 0.1) {
            Color.Green
        } else if (dineroT < 0.0) {
            Color.Red
        } else {
            Color.Black
        }
        explicito = if (dineroT > 0.1) {
            "Sobran"
        } else if (dineroT < 0.0) {
            "Faltan"
        } else  {
            "Todo Cuadra"
        }
    }
}