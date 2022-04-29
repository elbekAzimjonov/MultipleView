package com.elbek.multipleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elbek.multipleview.data.Products
import com.elbek.multipleview.databinding.FlashProductsItemBinding

class SalesAdapter(val list: ArrayList<Products.SaleProducts>) :
    RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {
    inner class SalesViewHolder(itemView: FlashProductsItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val image = itemView.flashImage
        fun onBind(products: Products.SaleProducts) {
            image.setImageResource(products.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val itemView = FlashProductsItemBinding.inflate(LayoutInflater.from(parent.context))
        return SalesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

}
