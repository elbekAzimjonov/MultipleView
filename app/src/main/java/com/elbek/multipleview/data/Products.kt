package com.elbek.multipleview.data
sealed class Products {
    class Title(
        val id: Int,
        val title: String,
        val viewAll: String,
    ) : Products()

    class Banner(
        val bannerImage: Int,
        val title: String
    ) : Products()

    class Category(
        val id: Int,
        val title: String,
        val image: Int
    ) : Products()

    class SaleProducts(
        val id: Int,
        val image: Int,
        val name: String,
        val category: String
    ) : Products()

    class MegaSaleProducts(
        val id: Int,
        val image: Int,
        val name: String,
        val category: String
    ) : Products()

    class MiddleBanner(
        val bannerImage: Int,
        val title: String
    ) : Products()

    class PopularProducts(
        val id: Int,
        val image: Int,
        val name: String,
        val category: String
    ) : Products()

}
