package com.example.android1homework6.data

import com.example.android1homework6.ui.fragments.DetailFragment

data class CatModel(
    val image: String? = null ,
    val name: String? = null,
    val detail: String? = null
) : java.io.Serializable{
    fun getImageUri(): String? {
        return image
    }
}