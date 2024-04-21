package com.example.a160418002utsanmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418002utsanmp.R
import com.example.a160418002utsanmp.viewmodel.ListBeritaModel
import com.squareup.picasso.Picasso

class DetailBeritaFragment : Fragment() {


    private lateinit var viewModel: ListBeritaModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val txtJudulDetail = view.findViewById<TextView>(R.id.txtJudulH)
        val txtUsernameDetail = view.findViewById<TextView>(R.id.txtUsername)
        val txtDesDetail = view.findViewById<TextView>(R.id.txtDesH)


    }


}