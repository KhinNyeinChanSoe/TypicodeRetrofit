package com.example.typicoderetrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.typicoderetrofit.api.ApiClient
import com.example.typicoderetrofit.model.HospitalsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel:ViewModel() {
    private var details_hospital :MutableLiveData<HospitalsItem> = MutableLiveData()
    fun getDetails() = details_hospital
    fun loadDetails(id:String){
        val apiClient = ApiClient()
        var apiCall = apiClient.getDetails(id)
        apiCall.enqueue(object :Callback<HospitalsItem>{
            override fun onResponse(call: Call<HospitalsItem>, response: Response<HospitalsItem>) {
                details_hospital.value = response.body()

            }

            override fun onFailure(call: Call<HospitalsItem>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }

        })
    }
}