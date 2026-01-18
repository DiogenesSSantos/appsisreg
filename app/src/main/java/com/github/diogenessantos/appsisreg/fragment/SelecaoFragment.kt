package com.github.diogenessantos.appsisreg.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.diogenessantos.appsisreg.activity.ArquivoMortoActivity
import com.github.diogenessantos.appsisreg.databinding.FragmentSelecaoBinding

class SelecaoFragment : Fragment() {
    private var _binding: FragmentSelecaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelecaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraOnclickListenerImage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun configuraOnclickListenerImage() {




        _binding?.imgMarcados?.setOnClickListener {
            Log.w("Img_marcado", "clickou na Imagem marcado",)
        }

        _binding?.imgArquivoMorto?.setOnClickListener {
            val intent = Intent(context, ArquivoMortoActivity::class.java)
            startActivity(intent)
        }
    }
}