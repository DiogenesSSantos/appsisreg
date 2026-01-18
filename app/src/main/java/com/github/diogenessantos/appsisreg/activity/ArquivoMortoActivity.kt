package com.github.diogenessantos.appsisreg.activity

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.github.diogenessantos.appsisreg.databinding.ActivityArquivoMortoBinding
import com.github.diogenessantos.appsisreg.dto.UsuarioDTO
import com.github.diogenessantos.appsisreg.dto.UsuarioResponse
import com.github.diogenessantos.appsisreg.functiokotlin.ModelToUsuarioDTOOuNull
import com.github.diogenessantos.appsisreg.viewmodel.ArquivoMortoViewModel

class ArquivoMortoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityArquivoMortoBinding
    private val arquivoMortoViewModel by lazy { ArquivoMortoViewModel() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArquivoMortoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configurarErro()
        configurarBotaoBuscarSubstituir()
        configurarViewModel()
        configuraBotaoEnviar()
    }

    private fun configurarErro(){
        binding.etCpfOuSus.doOnTextChanged { text, start, before, count ->
            if( text!!.isNotEmpty() && text!!.length < 11 ) {
                binding.tflCfpsusLayout.error = "Tamanho Cpf 8 números ou para sus 15 números."
            } else if (text!!.length > 11 && text!!.length < 15) {
                binding.tflCfpsusLayout.error = "Tamanho do sus é 15 números."
            } else {
                binding.tflCfpsusLayout.error = null
            }
        }
    }

    private fun configurarBotaoBuscarSubstituir(){
        binding.tflCfpsusLayout.setEndIconOnClickListener {
            val cpfOuSus = binding.etCpfOuSus.text?.toString() ?:""
            Log.i("CPFouSUS", "dados = $cpfOuSus ")
            if (!cpfOuSus.isBlank())arquivoMortoViewModel.carregarViewModelUsuario(cpfOuSus)
        }
    }

    private fun configurarViewModel(){
        arquivoMortoViewModel.usuario.observe(this, {
            val usuario = it
            if (usuario != null) {
                binding.etNome.setText(usuario.nome)
                binding.etDataNascimento.setText(usuario.dataNascimento)
                binding.etCpf.setText(usuario.cpf)
                binding.etNomeMae.setText(usuario.nomeMae)
                binding.etBairro.setText(usuario.bairro)

            }
        })
    }

    private fun configuraBotaoEnviar(){
        binding.btnSalvar.setOnClickListener {
            val usuarioDto = criarUsuarioDTOOuNull()
            if (usuarioDto != null) {
                arquivoMortoViewModel.salvar(usuarioDto)
            }else{
                Toast.makeText(this,
                    "Alguns campos obrigatórios preenchidos.",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun criarUsuarioDTOOuNull() : UsuarioDTO? {
        val textoSelecionado = buscarMsgMotivoSelecionado()
        val usuario: UsuarioResponse? = arquivoMortoViewModel.usuario.value
        val usuarioDTO: UsuarioDTO? = ModelToUsuarioDTOOuNull(usuario,textoSelecionado)
        return usuarioDTO
    }

    private fun buscarMsgMotivoSelecionado() : String? {
        val id = binding.rdgRadioGroup.checkedRadioButtonId
        if (id == -1) return null
        val radioButton = binding.rdgRadioGroup.findViewById<RadioButton>(id)
        val textoSelecionado = radioButton?.text?.toString() ?: ""
        return textoSelecionado
    }

}