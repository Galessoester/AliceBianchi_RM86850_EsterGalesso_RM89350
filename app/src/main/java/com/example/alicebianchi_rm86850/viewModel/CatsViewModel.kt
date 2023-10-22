package com.example.alicebianchi_rm86850.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alicebianchi_rm86850.model.CatModel
import com.example.alicebianchi_rm86850.model.ICatApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CatsViewModel(
    private val retrofitClient: Retrofit
) : ViewModel() {
    private val _rmiewState = MutableLiveData<CatViewState>()
    val catViewState: LiveData<CatViewState> get() = _rmiewState

    val liveCat = MutableLiveData<CatModel>()
    val liveError = MutableLiveData<String>()

    private var cat: CatModel? = null

    fun getCats() {
        _rmiewState.value = CatViewState.Loading
        val endPoint = getCatsEndPoint()
        val callBack = endPoint.getCatImages()
        callBack.enqueue(object : Callback<CatModel> {
            override fun onResponse(call: Call<CatModel>, response: Response<CatModel>) {
                cat = response.body()
                liveCat.value = cat
                // _rmiewState.value = CatViewState.Success(response.body()?.breeds)
            }

            override fun onFailure(call: Call<CatModel>, t: Throwable) {
                liveError.value = t.message
                //_rmiewState.value = CatViewState.Error(t.message)
            }
        })
    }

    private fun getCatsEndPoint(): ICatApi {
        return retrofitClient.create(ICatApi::class.java)
    }

    fun getCat(i: Int) {

    }

}

private fun <T> Call<T>.enqueue(callback: Callback<CatModel>) {

}
