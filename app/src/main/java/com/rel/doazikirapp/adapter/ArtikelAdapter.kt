package com.rel.doazikirapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rel.doazikirapp.databinding.ItemArtikelBinding
import com.rel.doazikirapp.model.ArtikelItem
import com.rel.doazikirapp.presentation.DetailArtikelActivity

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {
    private val listArtikel = ArrayList<ArtikelItem>()

    fun setData(list: List<ArtikelItem>) {
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    inner class ArtikelViewHolder(val view: ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ArtikelViewHolder (ItemArtikelBinding.inflate(
        LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount() = listArtikel.size

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
    val data = listArtikel[position]
        holder.view.itemArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            it.context.apply {
                val intent = Intent(this, DetailArtikelActivity::class.java)
                intent.putExtra("title",data.titleArtikel)
                intent.putExtra("content",data.contentArtikel)
                intent.putExtra("image",data.imageArtikel)
                startActivity(intent)
            }
        }
    }
}
