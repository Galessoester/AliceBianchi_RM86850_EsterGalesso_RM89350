package com.example.alicebianchi_rm86850.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alicebianchi_rm86850.model.BreedModel
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
    val liveCatDetails = MutableLiveData<BreedModel>()
    val liveError = MutableLiveData<String>()

    fun getCatEndPoint(): ICatApi =
        retrofitClient.create(ICatApi::class.java)

    fun getCatDatails(catDetails:String) {
        val endPoint = getCatEndPoint()
        val callBack = endPoint.gatCatDatails(catDetails)
        callBack.enqueue(object : Callback<BreedModel> {
            override fun onResponse(call: Call<BreedModel>, response: Response<BreedModel>) {
                liveCatDetails.value = response.body()
            }

            override fun onFailure(call: Call<BreedModel>, t: Throwable) {
                liveError.value = t.message
            }

        })
    }

    fun getCat(catNumber:Int){
        val endPoint = getCatEndPoint()
        cats?.let {
            val callBack = endPoint.getCats(catNumber)
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