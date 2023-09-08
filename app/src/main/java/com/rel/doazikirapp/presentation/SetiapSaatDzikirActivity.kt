package com.rel.doazikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rel.doazikirapp.adapter.DoaDzikirAdapter
import com.rel.doazikirapp.databinding.ActivitySetiapSaatDzikirBinding
import com.rel.doazikirapp.model.DataDoaDzikir

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private var _binding : ActivitySetiapSaatDzikirBinding? = null
    private val binding get() = _binding as ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDziksir())

        binding.rvDzikirSetiapSaat.adapter = mAdapter

        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(applicationContext)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}