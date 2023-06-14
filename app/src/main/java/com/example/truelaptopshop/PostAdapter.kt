package com.example.truelaptopshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class PostAdapter (val postModel: MutableList<PostModel>): RecyclerView.Adapter<PostViewHandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHandler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHandler(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostViewHandler, position: Int) {
        return holder.bindView(postModel[position])
    }
}


class PostViewHandler(itemView: View): RecyclerView.ViewHolder(itemView){
    private val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    private val price: TextView = itemView.findViewById(R.id.price)
    private val imageView: ShapeableImageView = itemView.findViewById(R.id.title_image)
    fun bindView(postModel: PostModel) {
        tvHeading.text = postModel.name
        price.text = postModel.price.toString()
        Picasso.get()
            .load(postModel.pic)
            .into(imageView)
    }
}
