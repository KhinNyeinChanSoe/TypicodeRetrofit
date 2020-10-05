package com.example.typicoderetrofit.api

import com.example.typicoderetrofit.model.Hospital
import com.example.typicoderetrofit.model.HospitalsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "http://hospitalguideapi.dsv.hoz.mybluehost.me/api/"
    private var hospitalInterface:HospitalApiInterface
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        hospitalInterface = retrofit.create(HospitalApiInterface::class.java)
    }
    fun getAllHospital(): Call<Hospital>{
        return hospitalInterface.getAllHospital()
    }
    fun getDetails(id: String):Call<HospitalsItem>{
        return hospitalInterface.getDetails(id)
    }
}