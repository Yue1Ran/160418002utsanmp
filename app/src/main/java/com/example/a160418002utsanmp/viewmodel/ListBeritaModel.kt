package com.example.a160418002utsanmp.viewmodel

import android.app.Application
import android.util.Log
import android.view.Menu
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160418002utsanmp.model.Berita
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListBeritaModel(app: Application, ) : AndroidViewModel(app) {
    val beritas = MutableLiveData<List<Berita>>()

    private val VOLLEY_TAG = "volley.berita"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue(getApplication())

        val stringRequest = StringRequest(
            Request.Method.GET,
            "http://10.0.2.2/Berita.json",
            { response ->
                Log.d("VolleyRequest.Berita", response)
                val cleanedResponse = response.replace(" mph", "")
                this.beritas.value = Gson().fromJson<List<Berita>>(
                    cleanedResponse,
                    object : TypeToken<List<Berita>>() {}.type,
                )
            },
            { error ->
                Log.d("VolleyRequest.Berita", error.message.toString())
            },
        )

        stringRequest.tag = VOLLEY_TAG

        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(VOLLEY_TAG)
    }
}
