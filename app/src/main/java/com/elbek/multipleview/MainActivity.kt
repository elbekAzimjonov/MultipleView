package com.elbek.multipleview

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elbek.multipleview.adapters.ProductsAdapter
import com.elbek.multipleview.data.Products

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: ArrayList<Products>
    private val productsAdapter = ProductsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList()
        recyclerView = findViewById(R.id.multiRecycler)
        list.add(Products.Title(1, "Featured", ""))
        list.add(Products.Banner(R.drawable.promotion_image, "Recom"))
        list.add(Products.Category(1, "Nimadir", R.drawable.ic_man_shirt))
        list.add(Products.Category(2, "Nimadir", R.drawable.ic_man_shirt))
        list.add(Products.SaleProducts(1, R.drawable.nike_one, "Nike", "New"))
        list.add(Products.SaleProducts(2, R.drawable.nike_one, "Nike", "New"))
        list.add(Products.SaleProducts(3, R.drawable.nike_one, "Nike", "New"))
        list.add(Products.SaleProducts(4, R.drawable.nike_one, "Nike", "New"))
        productsAdapter.submitList(list)
        recyclerView.apply {
            val gridLayoutManager = GridLayoutManager(this@MainActivity, 6)

            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (productsAdapter.getItemViewType(position)) {
                        R.layout.banner_rv_item -> 6
                        R.layout.title_item -> 6
                        R.layout.category_rv_item -> 3
                        R.layout.flash_products_item -> 3
                        else -> 1
                    }
                }
            }
            val linearLayoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

            layoutManager = gridLayoutManager
            setHasFixedSize(true)
            adapter = productsAdapter

        }
    }
}