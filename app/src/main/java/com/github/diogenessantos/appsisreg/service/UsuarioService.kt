package com.github.diogenessantos.appsisreg.service

import com.github.diogenessantos.appsisreg.dto.UsuarioDTO
import com.github.diogenessantos.appsisreg.dto.UsuarioResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsuarioService {

    @GET("buscar")
    suspend fun buscarPorCpfOuSus(@Query("susOuCpf") cpfOuSus : String) : Response<UsuarioResponse>

    @POST("salvar/arquivomorto")
    suspend fun salvarArquivoMorot(@Body usuarioDTO: UsuarioDTO) : Response<Any?>
}