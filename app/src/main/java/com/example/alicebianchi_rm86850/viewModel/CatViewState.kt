package com.example.alicebianchi_rm86850.viewModel

import com.example.alicebianchi_rm86850.model.BreedModel

sealed class CatViewState {
    object Loading : CatViewState()
    data class Success(val cats: List<BreedModel>?) : CatViewState()
    data class Error(val errorMessage: String?) : CatViewState()
}