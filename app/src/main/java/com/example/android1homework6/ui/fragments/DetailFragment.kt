package com.example.android1homework6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.android1homework6.R
import com.example.android1homework6.data.CatModel
import org.w3c.dom.Text


class DetailFragment : Fragment() {

    private var image:ImageView? = null
    private var text: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.Image_Detail)
        text = view.findViewById(R.id.Text_Detail)
        getData()
    }

    private fun getData() {
        val bundle = arguments
        if (bundle != null) {
            val dataModel = bundle.getSerializable("Dan") as CatModel
            image?.context?.let { Glide.with(it).load(dataModel.getImageUri()).into(image!!) }
            text?.setText(dataModel.detail)
        }
    }
}


