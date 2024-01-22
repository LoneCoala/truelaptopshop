package com.example.truelaptopshop.domain.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.truelaptopshop.R
import com.example.truelaptopshop.domain.model.PostModel
import com.example.truelaptopshop.presentation.laptopDetail.LaptopActivity
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso




class PostAdapter(private val postModel: MutableList<PostModel>): RecyclerView.Adapter<PostViewHandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHandler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHandler(view)
    }
    override fun getItemCount(): Int {
        return postModel.size
    }
    override fun onBindViewHolder(holder: PostViewHandler, position: Int) {
        val post = postModel[position]
        holder.openButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, LaptopActivity::class.java)
            intent.putExtra("name",postModel[position].name.toString())
            intent.putExtra("gpu",postModel[position].gpu.toString())
            intent.putExtra("cpu",postModel[position].cpu.toString())
            intent.putExtra("ram",postModel[position].ram.toString())
            intent.putExtra("ssd",postModel[position].ssd.toString())
            intent.putExtra("screen",postModel[position].screen.toString())
            intent.putExtra("os",postModel[position].os.toString())
            intent.putExtra("color",postModel[position].color.toString())
            intent.putExtra("pic",postModel[position].pic.toString())
            intent.putExtra("price",postModel[position].price.toString())
            holder.itemView.context.startActivity(intent)
        }

        return holder.bindView(postModel[position])
    }
}

class PostViewHandler(itemView: View): RecyclerView.ViewHolder(itemView){

    //-------------------------------------------//
    private val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    private val price: TextView = itemView.findViewById(R.id.price)
    private val imageView: ShapeableImageView = itemView.findViewById(R.id.title_image)
    val openButton: Button = itemView.findViewById(R.id.openButton)
    private val gpu: TextView = itemView.findViewById(R.id.gpu)


    fun bindView(postModel: PostModel) {

        tvHeading.text = postModel.name
        price.text = postModel.price.toString()
        gpu.text = postModel.gpu.toString()

        Picasso.get()
            .load(postModel.pic)
            .into(imageView)
    }

}




/*
class PostAdapter(private val postModel: MutableList<PostModel>, private val listener: OnItemClickListener): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(postModel: PostModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postModel[position]
        holder.bindView(post)

        holder.openButton.setOnClickListener {
            listener.onItemClick(post)
        }
    }

    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
        private val price: TextView = itemView.findViewById(R.id.price)
        private val imageView: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val openButton: Button = itemView.findViewById(R.id.openButton)
        private val gpu: TextView = itemView.findViewById(R.id.gpu)

        fun bindView(postModel: PostModel) {
            tvHeading.text = postModel.name
            price.text = postModel.price.toString()
            gpu.text = postModel.gpu.toString()

            Picasso.get()
                .load(postModel.pic)
                .into(imageView)
        }
    }
}*/
