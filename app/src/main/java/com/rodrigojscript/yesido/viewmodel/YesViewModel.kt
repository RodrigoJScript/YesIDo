package com.rodrigojscript.yesido.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rodrigojscript.yesido.model.YesRepository
import com.rodrigojscript.yesido.model.database.SaldoDia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class YesViewModel(application: Application) : AndroidViewModel(application) {

    private val yesRepository: YesRepository = YesRepository(application)
    private val dN: MutableLiveData<Double>? = null
    private val dF: MutableLiveData<Double>? = null

    fun getAllSaldo(): LiveData<MutableList<SaldoDia>> {
        return yesRepository.readAllSaldo
    }

    fun insertSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.insertSaldo(saldoDia)
        }
    }

    fun deleteSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.deleteSaldo(saldoDia)
        }
    }

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

    fun calcularDN(
        n1: String,
        n2: String,
        n3: String,
        n4: String,
        n5: String,
        n6: String,
        n7: String,
        n8: String,
        n9: String,
        n10: String,
        n11: String,
        n12: String,
        n13: String,
        n14: String,
        n15: String,
    ) {
        yesRepository.calcularDN(
            nota1 = n1,
            nota2 = n2,
            nota3 = n3,
            nota4 = n4,
            nota5 = n5,
            nota6 = n6,
            nota7 = n7,
            nota8 = n8,
            nota9 = n9,
            nota10 = n10,
            nota11 = n11,
            nota12 = n12,
            nota13 = n13,
            nota14 = n14,
            nota15 = n15
        )
    }

    fun explicidad(dineroT: Double) {
        yesRepository.explicidad(dineroT)
    }
}