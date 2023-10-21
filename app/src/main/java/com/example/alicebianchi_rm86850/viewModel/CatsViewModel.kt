package com.example.alicebianchi_rm86850.viewModel

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

    private var cats: CatModel? = null

    val liveCat = MutableLiveData<CatModel>()
    val liveError = MutableLiveData<String>()

    fun getCatEndPoint(): ICatApi =
        retrofitClient.create(ICatApi::class.java)

    fun getDeck() {
        val endPoint = getCatEndPoint()
        val callBack = endPoint.getCats(1)
        callBack.enqueue(object : Callback<CatModel> {
            override fun onResponse(call: Call<CatModel>, resp: Response<CatModel>) {
                cats = resp.body()
                liveCat.value = cats
            }

            override fun onFailure(call: Call<CatModel>, t: Throwable) {
                liveError.value = t.message
            }
        })
    }

    fun getCard(catNumber:Int){
        val endPoint = getCatEndPoint()
        cats?.let {
            val callBack = endPoint.getCats(it.id, catNumber)
            callBack.enqueue(object : Callback<CatModel>{
                override fun onResponse(call: Call<CatModel>, response: Response<CatModel>) {
                    liveCat.value = response.body()
                }

                override fun onFailure(call: Call<CatModel>, t: Throwable) {
                    liveError.value = t.message
                }
            })
        }

    }
}