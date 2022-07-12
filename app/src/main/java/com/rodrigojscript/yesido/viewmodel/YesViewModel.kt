package com.rodrigojscript.yesido.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.model.database.YesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class YesViewModel(application: Application) : AndroidViewModel(application) {

    private val db: YesDatabase = YesDatabase
        .getInstance(application)

    internal val saldoDias: LiveData<MutableList<SaldoDia>> =
        db.yesDao().getSaldoDia()

    fun insert(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            db.yesDao().insert(saldoDia)
        }
    }

    fun update(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            db.yesDao().update(saldoDia)
        }
    }

    fun delete(saldoDia: SaldoDia) {
        viewModelScope.launch(Dispatchers.IO) {
            db.yesDao().delete(saldoDia)
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            db.yesDao().clear()
        }
    }
}