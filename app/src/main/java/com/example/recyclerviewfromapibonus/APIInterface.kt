package com.example.recyclerviewfromapibonus


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIInterface {
   // @Headers("Content-Type: application/json")
    @GET("people/")
    fun getNames(): Call<Item>?
}