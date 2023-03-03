package com.example.checkpermission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.checkpermission.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!
    private lateinit var pLauncher : ActivityResultLauncher<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    // -- ПРОВЕРЯЕМ ПОЛУЧЕНИЕ РАЗРЕШЕНРИЯ --

    // метод запускается уже после отрисовки всех view
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission() // спрашиваем
    }

    private fun checkPermission() {
        // если Permission получен не был - получаем его
        if (!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    // метод как мы получаем Permission если он отсутствует
    private fun permissionListener() {
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permisson: $it", Toast.LENGTH_SHORT).show()
        }
    }
    // -- ПРОВЕРЯЕМ ПОЛУЧЕНИЕ РАЗРЕШЕНРИЯ --




    companion object {
        fun newInstance() = BlankFragment()
    }




}