package com.batdemir.similar.flora.example.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.batdemir.similar.flora.example.R
import com.batdemir.similar.flora.example.app.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication)
            .applicationComponent
            .mainComponent()
            .create()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getData()
    }
}