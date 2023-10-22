package com.example.alicebianchi_rm86850.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.alicebianchi_rm86850.databinding.ActivityGatinhosDetailBinding
import com.example.alicebianchi_rm86850.databinding.ActivityMainBinding
import com.example.alicebianchi_rm86850.databinding.GatinhosListItemBinding
import com.example.alicebianchi_rm86850.model.BreedModel
import com.example.alicebianchi_rm86850.model.CatModel
import com.example.alicebianchi_rm86850.model.ICatApi
import com.example.alicebianchi_rm86850.viewModel.CatsViewModel
import com.example.alicebianchi_rm86850.viewModel.CatsViewModelFactory
import retrofit2.Call

class MainActivity : AppCompatActivity(), ICatApi {

    private lateinit var activityBind: ActivityMainBinding
    private lateinit var itemBind: GatinhosListItemBinding
    private lateinit var detailBind: ActivityGatinhosDetailBinding
    private val adapter = CatsAdapter(this)

    private val catFactory = CatsViewModelFactory()
    private lateinit var viewModel: CatsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBind.root)

        viewModel = ViewModelProvider(this, catFactory)[CatsViewModel::class.java]

        //setupObservers()

        viewModel.getCat(1)
        activityBind.progress.visibility = View.VISIBLE

    }

    fun setupObservers() {
        viewModel.liveCat.observe(
            this,
            Observer(::setCatId)
        )
//        viewModel.liveError.observe(
//            this,
//            Observer(::showErrorMessage)
//        )
    }

    private fun setCatId(catModel: CatModel) {
        itemBind.txtCatId.text = catModel?.id
    }


//    private fun setupObservers() {
//        viewModel.liveCat.observe(this, Observer { state ->
//            when (state) {
//                is CatViewState.Loading -> {
//                    activityBind.progress.visibility = View.VISIBLE
//                }
//
//                is CatViewState.Success -> {
//                    state.breeds?.let { catFactory ->
//                        adapter.setList(catFactory)
//                    }
//                    activityBind.progress.visibility = View.GONE
//                }
//
//
//            }
//        })
//    }

    override fun getCatImages(): Call<List<CatModel>> {
        TODO("Not yet implemented")
    }

    override fun getCatDetails(catId: BreedModel): Call<BreedModel> {
        TODO("Not yet implemented")
    }
}