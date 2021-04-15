package com.femiras.framework.mvvm.ui.started.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.ActivityStartedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartedActivity : AppCompatActivity() {

    private lateinit var binding :ActivityStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_started)
        binding = ActivityStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}