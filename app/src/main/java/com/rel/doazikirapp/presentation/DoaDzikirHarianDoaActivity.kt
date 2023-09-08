package com.rel.doazikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rel.doazikirapp.adapter.DoaDzikirAdapter
import com.rel.doazikirapp.R
import com.rel.doazikirapp.databinding.ActivityHarianDzikirDoaBinding
import com.rel.doazikirapp.model.DoaDzikirItem

class DoaDzikirHarianDoaActivity : AppCompatActivity() {

    private var _binding : ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()
    }

    private fun initView() {
        binding.rvDzikirDoaHarian.apply {
            val mAdapter = DoaDzikirAdapter()
            mAdapter.setData(providingDzikirDatas())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    private fun providingDzikirDatas() : List <DoaDzikirItem> {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translationDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikirItem>()
        for (index in titleDzikir.indices) {
                val data = DoaDzikirItem(
                    titleDzikir[index],
                    arabicDzikir[index],
                    translationDzikir[index]
                )
                listData.add(data)
        }
        return listData
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

}