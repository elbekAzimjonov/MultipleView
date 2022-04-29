package com.elbek.multipleview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elbek.multipleview.R
import com.elbek.multipleview.data.Products
import com.elbek.multipleview.databinding.BannerRvItemBinding
import com.elbek.multipleview.databinding.CategoryRvItemBinding
import com.elbek.multipleview.databinding.FlashProductsItemBinding
import com.elbek.multipleview.databinding.TitleItemBinding
import com.elbek.multipleview.viewHolder.NftViewHolder

class ProductsAdapter : ListAdapter<Products, NftViewHolder>(NftDiffCallBack()) {
    var itemClickListener: ((view: View, item: Products, position: Int) -> Unit)? = null

    class NftDiffCallBack : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
            return when {
                oldItem is Products.Title && newItem is Products.Title -> {
                    oldItem.id == newItem.id
                }
//                oldItem is Products.SaleProducts && newItem is Products.SaleProducts -> {
//                    oldItem.id == newItem.id
//                }
                else -> {
                    false
                }
            }
        }

        override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
            return when {
                oldItem is Products.Title && newItem is Products.Title -> {
                    oldItem == newItem
                }
                oldItem is Products.Banner && newItem is Products.Banner -> {
                    oldItem == newItem
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftViewHolder {
        return when (viewType) {
            R.layout.title_item -> NftViewHolder.TitleViewHolder(
                TitleItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.banner_rv_item -> NftViewHolder.BannerViewHolder(
                BannerRvItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.category_rv_item -> NftViewHolder.CategoryViewHolder(
                CategoryRvItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.flash_products_item -> NftViewHolder.FlashSaleViewHolder(
                FlashProductsItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: NftViewHolder, position: Int) {
        holder.itemClickListener = itemClickListener

        val item = getItem(position)
        when (holder) {
            is NftViewHolder.BannerViewHolder -> holder.bind(item as Products.Banner)
            is NftViewHolder.TitleViewHolder -> holder.bind(item as Products.Title)
            is NftViewHolder.CategoryViewHolder -> holder.bind(item as Products.Category)
            is NftViewHolder.FlashSaleViewHolder -> holder.bind(item as Products.SaleProducts)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Products.Banner -> R.layout.banner_rv_item
            is Products.Title -> R.layout.title_item
            is Products.Category -> R.layout.category_rv_item
            is Products.SaleProducts -> R.layout.flash_products_item
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

}