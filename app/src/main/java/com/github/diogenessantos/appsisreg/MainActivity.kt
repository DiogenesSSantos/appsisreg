package com.github.diogenessantos.appsisreg

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.diogenessantos.appsisreg.databinding.ActivityMainBinding
import com.github.diogenessantos.appsisreg.ui.theme.AppsisregTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding
    private  var increment = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureButton()

    }


    private fun configureButton(){

        binding.btnLogin.setOnClickListener {
            var pegandoEscritoLogin : String = binding.txtLogin.text?.toString() ?: "A login está Está nullo"
            var pegandoASenha : String = binding.txtSenha.text?.toString() ?: " O botão login está nulla"

            Log.w("Clicado", " Botão foi clicado ${increment}", )
            println(pegandoASenha + "\n ${pegandoEscritoLogin}" )
            increment++
        }
    }

}



