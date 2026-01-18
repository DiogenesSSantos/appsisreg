package com.github.diogenessantos.appsisreg.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.diogenessantos.appsisreg.databinding.ActivityMainBinding
import com.github.diogenessantos.appsisreg.fragment.SelecaoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureButton()

    }


    private fun configureButton(){
        binding.btnLogin.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id,
                    SelecaoFragment()
                ) .addToBackStack(null)
                .commit()


        }
    }

}