package com.github.diogenessantos.appsisreg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.diogenessantos.appsisreg.model.Usuario
import com.github.diogenessantos.appsisreg.service.SisregAPIService
import kotlin.uuid.Uuid

class ArquivoMortoViewModel (private val service: SisregAPIService = SisregAPIService()) : ViewModel() {

    private val _usuario = MutableLiveData<Usuario?>()
    val usuario : LiveData<Usuario?>
        get() = _usuario


     fun carregarViewModelUsuario(cpfOuSus : String) {
         val usuario = service.buscarUsuarioPorSusOuCpf(cpfOuSus)
         _usuario.value = usuario
    }


}