package com.github.diogenessantos.appsisreg.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.github.diogenessantos.appsisreg.databinding.ActivityArquivoMortoBinding
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

}