package com.example.alicebianchi_rm86850.viewModel

import retrofit2.Retrofit

class CatsViewModelFactory(
    private val retrofit: Retrofit = NetworkUtils.getRetrofitInstance("https://deckofcardsapi.com/api/deck/")
) {
}