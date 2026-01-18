package com.github.diogenessantos.appsisreg.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.diogenessantos.appsisreg.dto.UsuarioDTO
import com.github.diogenessantos.appsisreg.dto.UsuarioResponse
import com.github.diogenessantos.appsisreg.service.UsuarioService
import com.github.diogenessantos.appsisreg.model.Usuario
import com.github.diogenessantos.appsisreg.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import kotlin.math.log

class ArquivoMortoViewModel (private val usuarioService : UsuarioService =
    RetrofitInstance.getInstaceRetrofit()
    .create(UsuarioService::class.java)
) : ViewModel() {

    private val _usuario = MutableLiveData<UsuarioResponse?>()
    val usuario : LiveData<UsuarioResponse?>
        get() = _usuario

     fun carregarViewModelUsuario(cpfOuSus : String) {
         viewModelScope.launch {
             Log.w("ViewModelScope", "Buscando....", )
             val usuarioResponse = usuarioService.buscarPorCpfOuSus(cpfOuSus)
             _usuario.value = usuarioResponse.body()
             Log.w("ViewModelScope", "Terminando....", )
         }


    }

    fun salvar(usuarioDTO: UsuarioDTO) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    usuarioService.salvarArquivoMorot(usuarioDTO)
                }

                val msg = response.toString()
                Log.i("methodsalvar", msg)
            } catch (e: Exception) {
                Log.e("methodsalvar", "erro", e)
            }
            Log.i("methodsalvar", "terminou método salvar")
        }
    }

}