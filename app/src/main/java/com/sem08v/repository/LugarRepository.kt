package com.sem08v.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sem08v.data.LugarDao
import com.sem08v.model.Lugar

class LugarRepository(private val lugarDao: LugarDao) {
     fun guardarLugar(lugar: Lugar) {
        lugarDao.guardarLugar(lugar)
    }
     fun deleteLugar(lugar: Lugar){
        lugarDao.eliminarLugar(lugar)
    }


    val obtenerLugares: MutableLiveData<List<Lugar>> = lugarDao.getLugares()
}