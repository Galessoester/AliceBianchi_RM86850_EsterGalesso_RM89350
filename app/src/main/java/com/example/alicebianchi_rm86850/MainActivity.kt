package com.example.alicebianchi_rm86850

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.alicebianchi_rm86850.databinding.ActivityMainBinding
import com.example.alicebianchi_rm86850.viewModel.CatsViewModel
import com.example.alicebianchi_rm86850.viewModel.CatsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var databind: ActivityMainBinding

    private val deckFactory = CatsViewModelFactory()
    private lateinit var viewModel: CatsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(databind.root)

        viewModel = ViewModelProvider(this, CatsViewModelFactory())[CatsViewModel::class.java]

        observeViewModel()

        setupReclycler()
        viewModel.getCharacters()
    }

    fun setupObservers() {
        viewModel.liveCat.observe(
            this,
            Observer(::setCatId)
        )
        viewModel.liveCatDetails.observe(
            this,
            Observer(::setDetails)
        )
        viewModel.liveError.observe(
            this,
            Observer(::showErrorMessage)
        )
    }



}