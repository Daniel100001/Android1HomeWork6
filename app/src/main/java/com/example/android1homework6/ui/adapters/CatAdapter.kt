package com.example.android1homework6.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android1homework6.R
import com.example.android1homework6.data.CatModel
import com.example.android1homework6.interfaces.OnItemClick

class CatAdapter(private var listModel: MutableList<CatModel>

) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {


    class CatViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private var onItemClick: OnItemClick? = null
        private var image: ImageView? = null
        private var name: TextView? = null
        private var detail: TextView? = null
        init {
            image = view.findViewById(R.id.image_cat)
            name = view.findViewById(R.id.text_status_code)
        }
        fun setClickItem(onItemClick: OnItemClick) {
            this.onItemClick = onItemClick
        }
        fun onBind(catModel: CatModel) {
            image?.let { Glide.with(it.context).load(catModel.image).into(image!!) }
            name?.text = catModel.name
            itemView.setOnClickListener(View.OnClickListener {
                    onItemClick?.onClick(itemView.tag as CatModel)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(LayoutInflater.from(
            parent.context).inflate(R.layout.item_cat, parent , false)
        )
    }

    override fun getItemCount(): Int = listModel.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listModel[position])
    }
}