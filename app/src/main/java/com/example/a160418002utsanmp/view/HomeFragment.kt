package com.example.a160418002utsanmp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418002utsanmp.R
import com.example.a160418002utsanmp.viewmodel.ListBeritaModel


class HomeFragment : Fragment() {

    private val beritaViewModel : ListBeritaModel by viewModels()
    private val beritaAdapter = BeritaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):View? {
        return inflater.inflate(R.layout.fragment_home,container,false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerViewBerita).apply {
            adapter = beritaAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        beritaViewModel.beritas.observe(viewLifecycleOwner) { beritas ->
            Log.d("ObserveViewModel.beritas", "size: ${beritas.size}")
            beritaAdapter.updateData(beritas)
        }

        beritaViewModel.refresh()
    }



}