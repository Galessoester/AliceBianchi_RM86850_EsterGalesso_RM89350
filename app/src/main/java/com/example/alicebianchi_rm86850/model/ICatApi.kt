package com.example.alicebianchi_rm86850.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICatApi {
    @GET("search")
    fun getCats(
        @Query("limit") limit: Int
    ): Call<CatModel>

    @GET("{id}")
    fun gatCat(
        @Path("id") id:String
    ): Call<BreedModel>
}