package com.example.android1homework6.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android1homework6.R
import com.example.android1homework6.data.CatModel
import com.example.android1homework6.ui.fragments.CatFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view,CatFragment())
            .commit()
    }
}