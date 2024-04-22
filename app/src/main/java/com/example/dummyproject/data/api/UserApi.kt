package com.example.dummyproject.data.api

import com.example.dummyproject.data.response.InformationItem
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getData() : Call<List<InformationItem>>
}