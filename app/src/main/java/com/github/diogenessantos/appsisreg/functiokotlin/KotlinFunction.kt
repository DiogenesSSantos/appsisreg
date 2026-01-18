package com.github.diogenessantos.appsisreg.functiokotlin

import com.github.diogenessantos.appsisreg.dto.UsuarioDTO
import com.github.diogenessantos.appsisreg.dto.UsuarioResponse


fun ModelToUsuarioDTOOuNull(usuario: UsuarioResponse?, motivo: String?) : UsuarioDTO? {
    val nome = usuario?.nome
    val sus = usuario?.sus
    val dataNascimento = usuario?.dataNascimento
    val cpf = usuario?.cpf
    val nomeDaMae = usuario?.nomeMae
    val numero = usuario?.celular
    val bairro = usuario?.bairro
    val motivo = motivo
    if (nome == null || sus == null || cpf == null || motivo == null) return null

    return UsuarioDTO(nome, sus ,cpf, dataNascimento,
        nomeDaMae, numero , bairro,motivo)
}
