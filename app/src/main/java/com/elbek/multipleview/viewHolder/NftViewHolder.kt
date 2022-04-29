package com.elbek.multipleview.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.elbek.multipleview.data.Products
import com.elbek.multipleview.databinding.*


sealed class NftViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    var itemClickListener: ((view: View, item: Products, position: Int) -> Unit)? = null

    class TitleViewHolder(private val binding: TitleItemBinding) : NftViewHolder(binding) {
        fun bind(title: Products.Title) {
            binding.titleCategory.text = title.title
            binding.seeMore.text = title.viewAll
            binding.seeMore.setOnClickListener {
                itemClickListener?.invoke(it, title, adapterPosition)
            }
        }
    }

    class BannerViewHolder(private val binding: BannerRvItemBinding) : NftViewHolder(binding) {
        fun bind(featured: Products.Banner) {
            binding.imageBanner.setImageResource(featured.bannerImage)
            binding.imageBanner.setOnClickListener {
                itemClickListener?.invoke(it, featured, adapterPosition)
            }
            binding.titleBanner.text = featured.title
        }
    }

    class CategoryViewHolder(private val binding: CategoryRvItemBinding) : NftViewHolder(binding) {
        fun bind(topPicks: Products.Category) {
            binding.categoryImage.setImageResource(topPicks.image)
            binding.categoryImage.setOnClickListener {
                itemClickListener?.invoke(it, topPicks, adapterPosition)
            }
            binding.categoryTitle.text = topPicks.title
        }
    }

    class FlashSaleViewHolder(private val binding: FlashProductsItemBinding) :
        NftViewHolder(binding) {
        fun bind(trending: Products.SaleProducts) {

            binding.flashImage.setImageResource(trending.image)

            binding.titleFlash.setOnClickListener {
                itemClickListener?.invoke(it, trending, adapterPosition)
            }
            binding.titleFlash.text = trending.name
        }
    }
    class MiddleBannerViewHolder(private val binding: MiddleBannerItemBinding) :
        NftViewHolder(binding) {
        fun bind(trending: Products.MiddleBanner) {

            binding.imageBanner.setImageResource(trending.bannerImage)

            binding.imageBanner.setOnClickListener {
                itemClickListener?.invoke(it, trending, adapterPosition)
            }
            binding.middleTittle.text = trending.title
        }
    }
    class PopularSaleViewHolder(private val binding: FlashProductsItemBinding) :
        NftViewHolder(binding) {
        fun bind(trending: Products.PopularProducts) {

            binding.flashImage.setImageResource(trending.image)

            binding.titleFlash.setOnClickListener {
                itemClickListener?.invoke(it, trending, adapterPosition)
            }
            binding.titleFlash.text = trending.name
        }
    }
    class HorizontalSaleViewHolder(private val binding: HorizontanRvBinding) :
        NftViewHolder(binding) {
        fun bind(trending: Products.PopularProducts) {


        }
    }
}