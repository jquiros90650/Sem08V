package com.sem08v.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sem08v.R
import com.sem08v.databinding.FragmentAddLugarBinding
import com.sem08v.databinding.FragmentUpdateLugarBinding
import com.sem08v.model.Lugar
import com.sem08v.viewModel.HomeViewModel

class UpdateLugarFragment : Fragment() {

    // Recuperar los elementos enviados
    private val args by navArgs<UpdateLugarFragmentArgs>()

    private var _binding: FragmentUpdateLugarBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel:HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentUpdateLugarBinding.inflate(inflater,container, false)


        // carga de lugar
        binding.etNombre.setText(args.lugarArg.nombre)
        binding.etCorreoLugar.setText(args.lugarArg.correo)
        binding.etTelefono.setText(args.lugarArg.telefono)
        binding.etWeb.setText(args.lugarArg.web)

        binding.btUpdateLugar.setOnClickListener {updateLugar()}
        //binding.btDeleteLugar.setOnClickListener {deleteLugar()}


        // Inflate the layout for this fragment
        return binding.root
    }
private fun updateLugar(){
    val nombre = binding.etNombre.text.toString()
    val correo = binding.etCorreoLugar.text.toString()
    val telefono = binding.etTelefono.text.toString()
    val web = binding.etWeb.text.toString()
    if (nombre.isNotEmpty()){
        val lugar = Lugar(args.lugarArg.id,nombre, correo, telefono,web)
        homeViewModel.guardarLugar(lugar)
        Toast.makeText(requireContext(),getText(R.string.ms_UpdateLugar),Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateLugarFragment_to_nav_home)
    }
    else{
        Toast.makeText(requireContext(),getString(R.string.ms_FaltaValores),Toast.LENGTH_LONG).show()
    }


}

}