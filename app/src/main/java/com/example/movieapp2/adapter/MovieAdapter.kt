package com.example.movieapp2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp2.databinding.CardViewDesignBinding
import com.example.movieapp2.model.Movie

class MovieAdapter(
    private val context: Context,
    private val mList: List<Movie>
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = ViewHolder(
            CardViewDesignBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return vh

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = mList[position]
        // holder.itemBinding.imageSample1.setImageResource()
        holder.itemBinding.title.text = movie.title
        holder.itemBinding.description.text = movie.description
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context, "${holder.itemBinding.title.text} clicked", Toast.LENGTH_SHORT
            ).show()
        }

        Glide.with(context).load(movie.img).into(holder.itemBinding.imageSample1)

    }


    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(val itemBinding: CardViewDesignBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }
}

