package com.example.alicebianchi_rm86850.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alicebianchi_rm86850.NetworkUtils
import retrofit2.Retrofit

class CatsViewModelFactory(
    private val retrofit: Retrofit = NetworkUtils.retroFitInstance("https://api.thecatapi.com/v1/images/")
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(CatsViewModel::class.java) ->
                    CatsViewModel(retrofit)

                else ->
                    throw IllegalArgumentException("Classe desconhecida.")
            }
        } as T
    }
}