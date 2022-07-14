package com.rodrigojscript.yesido.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.rodrigojscript.yesido.model.database.SaldoDia
import com.rodrigojscript.yesido.model.database.YesDao
import com.rodrigojscript.yesido.model.database.YesDatabase

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
}