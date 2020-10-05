package com.example.typicoderetrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.typicoderetrofit.api.ApiClient
import com.example.typicoderetrofit.model.Hospital
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel :ViewModel(){
    private var hospital : MutableLiveData<Hospital> = MutableLiveData()
    fun getHospital() = hospital
    fun loadHospital(){
        val apiClient = ApiClient()
        var apiCall = apiClient.getAllHospital()
        apiCall.enqueue(object : Callback<Hospital>{
            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                hospital.value = response.body()
                Log.d("Result:>>>>>",response.body().toString())
            }

            override fun onFailure(call: Call<Hospital>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }

        })
    }
}