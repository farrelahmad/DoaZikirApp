package com.rel.doazikirapp

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.rel.doazikirapp.adapter.ArtikelAdapter
import com.rel.doazikirapp.databinding.ActivityMainBinding
import com.rel.doazikirapp.model.ArtikelItem
import com.rel.doazikirapp.presentation.DoaDzikirHarianDoaActivity
import com.rel.doazikirapp.presentation.pagipetang.PagiPetangDzikirActivity
import com.rel.doazikirapp.presentation.QauliahShalatActivity
import com.rel.doazikirapp.presentation.SetiapSaatDzikirActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayListOf<ImageView?>()

    private val SlidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Toast.makeText(this@MainActivity, "Page $position", Toast.LENGTH_LONG).show()
            for (i in initData().indices) {
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }

            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        initView()
        setupViewPager()
    }

    private fun setupViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices) {
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.inactive_dot)
            )
            val param = LinearLayoutCompat.LayoutParams(35, 35)
            param.marginStart = 8
            param.marginEnd = 8
            binding.dots.addView(dotSliderIndicator[i])
        }
    }

    private fun initView() {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardQauliahShalat = findViewById<MaterialCardView>(R.id.card_qauliah_shalat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_doa_stiap_shalat)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_doa_harian)
        val cardPagiPetang = findViewById<MaterialCardView>(R.id.card_dzikir_pagi_petang)


        cardQauliahShalat.setOnClickListener {
            val intent = Intent(this, QauliahShalatActivity::class.java)
            startActivity(intent)
        }

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardPagiPetang.setOnClickListener(this)

        val mAdapter = ArtikelAdapter()
        mAdapter.setData(initData())
        binding.vpArtikel.adapter = mAdapter
        binding.vpArtikel.registerOnPageChangeCallback(SlidingCallback)
    }

    private fun initData(): List<ArtikelItem> {
        val judulArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val contentArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        val listData = arrayListOf<ArtikelItem>()

        for (i in judulArtikel.indices) {
            val data = ArtikelItem(
                judulArtikel[i], contentArtikel[i], imageArtikel.getResourceId(i, 0)
            )
            listData.add(data)
        }
        imageArtikel.recycle()
        return listData
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.card_doa_stiap_shalat -> startActivity(
                Intent(
                    this, SetiapSaatDzikirActivity::class.java
                )
            )

            R.id.card_dzikir_doa_harian -> startActivity(
                Intent(
                    this, DoaDzikirHarianDoaActivity::class.java
                )
            )

            R.id.card_dzikir_pagi_petang -> startActivity(
                Intent(
                    this, PagiPetangDzikirActivity::class.java
                )
            )

        }
    }
}