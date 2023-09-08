package com.rel.doazikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rel.doazikirapp.adapter.DoaDzikirAdapter
import com.rel.doazikirapp.R
import com.rel.doazikirapp.databinding.ActivityPagiBinding
import com.rel.doazikirapp.model.DataDoaDzikir

class PagiActivity : AppCompatActivity() {

    private var _binding : ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_dzikir_pagi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDzikirPagi())

        binding.rvDzikirPagi.adapter = mAdapter

        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}