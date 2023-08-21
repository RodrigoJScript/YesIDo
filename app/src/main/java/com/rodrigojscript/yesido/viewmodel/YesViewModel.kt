package com.rodrigojscript.yesido.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.rodrigojscript.yesido.model.YesRepository
import com.rodrigojscript.yesido.model.database.DineroEnNotas
import com.rodrigojscript.yesido.model.database.SaldoDia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Yes view model: Para conectar view con model
 *
 * @constructor
 *
 * @param application
 */
class YesViewModel(application: Application) : AndroidViewModel(application) {

    private val yesRepository: YesRepository = YesRepository(application)

    /**
     * Get all saldo
     *
     * @return
     */
    fun getAllSaldo(): LiveData<MutableList<SaldoDia>> {
        return yesRepository.readAllSaldo
    }

    fun getAllNotas(): LiveData<MutableList<DineroEnNotas>> {
        return yesRepository.readAllNotas
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.clear()
        }
    }

    /**
     * Insert saldo
     *
     * @param saldoDia
     */
    fun insertSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.insertSaldo(saldoDia)
        }
    }

    fun insertNotas(dineroEnNotas: DineroEnNotas) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.insertNotas(dineroEnNotas)
        }
    }

    /**
     * Delete saldo
     *
     * @param saldoDia
     */
    fun deleteSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.deleteSaldo(saldoDia)
        }
    }

    fun deleteNota(dineroEnNotas: DineroEnNotas) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.deleteNota(dineroEnNotas)
        }
    }

    /**
     * Calcular d f
     *
     * @param nMil
     * @param nQui
     * @param nDoc
     * @param nCie
     * @param nCin
     * @param nVei
     * @param nDie
     * @param nCco
     * @param nDos
     * @param nUno
     * @param nCen
     */
    fun calcularDF(
        nMil: String,
        nQui: String,
        nDoc: String,
        nCie: String,
        nCin: String,
        nVei: String,
        nDie: String,
        nCco: String,
        nDos: String,
        nUno: String,
        nCen: String,
    ) {
        yesRepository.calcularDF(
            numberMil = nMil,
            numberQui = nQui,
            numberDoc = nDoc,
            numberCie = nCie,
            numberCin = nCin,
            numberVei = nVei,
            numberDie = nDie,
            numberCco = nCco,
            numberDos = nDos,
            numberUno = nUno,
            numberCen = nCen
        )
    }

    /**
     * Explicidad
     *
     * @param dineroT
     */
    fun explicidad(dineroT: Double) {
        yesRepository.explicidad(dineroT)
    }

     fun getLastSevenDayDineroTotal(list: List<SaldoDia>): ChartEntryModel {
        return yesRepository.getDataForChart(list = list)
    }
}