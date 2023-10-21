package com.example.alicebianchi_rm86850

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alicebianchi_rm86850.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var databind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}