package com.example.alicebianchi_rm86850.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ICatApi {
    @GET("images/search?limit=2")
    fun getCatImages(): Call<List<CatModel>>

    @GET("images/{catId}")
    fun getCatDetails(@Path("catId") catId: BreedModel): Call<BreedModel>
}