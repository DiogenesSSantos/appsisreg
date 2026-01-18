package com.github.diogenessantos.appsisreg.dto

import com.google.gson.annotations.SerializedName

data class UsuarioResponse(@SerializedName("nome")
                           val nome: String?,

                           @SerializedName("sus")
                           val sus: String,

                           @SerializedName("cpf")
                           val cpf: String?,

                           @SerializedName("dataNascimento")
                           val dataNascimento: String?,

                           @SerializedName("nomeMae")
                           val nomeMae: String?,

                           @SerializedName("celular")
                           val celular: String,

                           @SerializedName("bairro")
                           val bairro: String?)
