package com.github.diogenessantos.appsisreg.service

import com.github.diogenessantos.appsisreg.model.Usuario


class SisregAPIService {
    private val listaUsuarios : List<Usuario> = listOf(
        Usuario("Diogenes",
            "700707404307080",
            "12485879443",
            "16/10/1957 (68 anos)",
            "Maria Jose da Silva Santos",
            "(81) 99836-9697",
            "LIDIA QUEIROZ"),

        Usuario("Severio Bio",
            "700707404307080",
            "12485879443",
            "30/10/1957 (68 anos)",
            "Amara barbosa",
            "(81) 99836-9697",
            "Santo"),

        Usuario("Maria jose da Silva Santos",
            "700707404307080",
            "12485879443",
            "02/01/1957 (68 anos)",
            "Maria jose silva",
            "(81) 99836-9697",
            "Sitio do meio")
    )



    fun buscarUsuarioPorSusOuCpf(susOuCpf : String) : Usuario?{
        //Todo Retrofit consumo api.
        return listaUsuarios.random()

    }

    fun salvarNaPlanilhaArquivoMorto(usuario : Usuario){
        //Todo enviar para api aonde persistimos na planinhas googleSheets.
    }

}