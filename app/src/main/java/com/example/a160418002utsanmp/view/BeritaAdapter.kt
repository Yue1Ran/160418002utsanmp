package com.example.a160418002utsanmp.view

import android.icu.text.NumberFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418002utsanmp.R
import com.example.a160418002utsanmp.model.Berita
import com.squareup.picasso.Picasso

class BeritaAdapter (
    private val beritas: MutableList<Berita> = mutableListOf(),
    ): RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    class ViewHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        val imageview : ImageView
        val textjudul: TextView
        val textUsername: TextView
        val textDes: TextView

        init {
            imageview = view.findViewById(R.id.imageBg)
            textjudul = view.findViewById(R.id.txtJudulH)
            textUsername = view.findViewById(R.id.txtUsernameH)
            textDes = view.findViewById(R.id.txtDesH)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_berita, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = beritas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            val berita = beritas[position]
            Picasso.get().load(berita.image).into(imageview)
            textjudul.text =
               berita.judul
            textUsername.text =
                berita.username
            textDes.text =
                berita.des
        }
    }

    fun updateData(data: List<Berita>) {
        beritas.clear()
        beritas.addAll(data)
        notifyDataSetChanged()
    }
}