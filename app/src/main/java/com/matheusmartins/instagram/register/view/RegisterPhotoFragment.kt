package com.matheusmartins.instagram.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matheusmartins.instagram.R
import com.matheusmartins.instagram.common.view.CustomDialog

class RegisterPhotoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customDialog = CustomDialog(requireContext())

        customDialog.addButton(R.string.photo, R.string.gallery, R.string.cancel) {
            when (it.id) {
                R.string.photo -> {
                    Log.i("Teste", "foto")
                    //agora a gente consegue abrir a camera
                }
                R.string.gallery -> {
                    Log.i("Teste", "galeria")
                    //agora a gente consegue abrir a galeria
                }
            }
        }
        customDialog.show()
    }
}