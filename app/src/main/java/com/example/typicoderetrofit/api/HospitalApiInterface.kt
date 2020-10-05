package com.example.typicoderetrofit.api

import com.example.typicoderetrofit.model.Hospital
import com.example.typicoderetrofit.model.HospitalsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalApiInterface {
    @GET("hospital")
    fun getAllHospital(): Call<Hospital>

    @GET("hospital/{id}")
    fun getDetails(
        @Path("id") id: String
    ):Call<HospitalsItem>

}