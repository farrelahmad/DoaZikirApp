package com.rel.doazikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailArtikelActivity : AppCompatActivity() {
    private var _binding : Deta
    private val binding get() = _binding as DetailArtikelActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val titleArtikel = intent.getStringExtra("title")
        val contentArtikel = intent.getStringExtra("content")
        val imageArtikel = intent.getIntExtra("image", 1)

        binding.apply {
            tvDetail.text = titleArtikel
        }
    }
}