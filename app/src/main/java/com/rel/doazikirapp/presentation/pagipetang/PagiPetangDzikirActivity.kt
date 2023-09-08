    package com.rel.doazikirapp.presentation.pagipetang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.rel.doazikirapp.R

    class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_pagi_petang_dzikir)
        initView()
    }
        private fun initView () {
            val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
            val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

            btnPagi.setOnClickListener(this)
            btnPetang.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
                R.id.img_btn_dzikir_petang -> startActivity(Intent(this, PetangActivity::class.java))
            }
        }
        override fun onSupportNavigateUp(): Boolean {
            onBackPressedDispatcher.onBackPressed()
            finish()
            return super.onSupportNavigateUp()
        }
    }