package com.rodrigojscript.yesido.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rodrigojscript.yesido.model.YesRepository
import com.rodrigojscript.yesido.model.database.SaldoDia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class YesViewModel(application: Application) : AndroidViewModel(application) {

    private val yesRepository: YesRepository = YesRepository(application)
    fun getAllSaldo(): LiveData<MutableList<SaldoDia>> {
        return yesRepository.readAllSaldo
    }

    fun insertSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch {
            yesRepository.insertSaldo(saldoDia)
        }
    }

    fun deleteSaldo(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            yesRepository.deleteSaldo(saldoDia)
        }
    }
}