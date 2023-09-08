package com.rel.doazikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rel.doazikirapp.adapter.DoaDzikirAdapter
import com.rel.doazikirapp.R
import com.rel.doazikirapp.databinding.ActivityPetangBinding
import com.rel.doazikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {

    private var _binding : ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.dzikir_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPetang())

        binding.rvDzikirPetang.adapter = mAdapter

        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}