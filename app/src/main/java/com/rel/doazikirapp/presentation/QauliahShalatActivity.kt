package com.rel.doazikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rel.doazikirapp.adapter.DoaDzikirAdapter
import com.rel.doazikirapp.model.DataDoaDzikir.listQauliyah
import com.rel.doazikirapp.databinding.ActivityQauliahShalatBinding

class QauliahShalatActivity : AppCompatActivity() {

    private var _binding : ActivityQauliahShalatBinding? = null
    private val binding get() = _binding as ActivityQauliahShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityQauliahShalatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(listQauliyah)

        binding.rvQauliyahShalat.adapter = mAdapter

        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(applicationContext)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}