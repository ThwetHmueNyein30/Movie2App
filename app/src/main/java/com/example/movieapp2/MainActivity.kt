package com.example.movieapp2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp2.adapter.MovieAdapter
import com.example.movieapp2.data.DataSource
import com.example.movieapp2.databinding.ActivityMainBinding
import com.example.movieapp2.databinding.CardViewDesignBinding
import com.example.movieapp2.model.Movie

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val data = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val movieAdapter = MovieAdapter(this, data)
        binding.recyclerview.adapter = movieAdapter

        setUpData()
    }

    private fun setUpData() {
        data.addAll(DataSource.movies)
    }


}
