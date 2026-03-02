package com.codepath.lab6

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImageView: ImageView = findViewById(R.id.detailImage)
        val detailTitleTextView: TextView = findViewById(R.id.detailTitle)
        val detailDescriptionTextView: TextView = findViewById(R.id.detailDescription)

        // 1) Try Park first (old behavior)
        @Suppress("DEPRECATION")
        val park = intent.getSerializableExtra(PARK_EXTRA) as? Park

        if (park != null) {
            detailTitleTextView.text = park.fullName.orEmpty()
            detailDescriptionTextView.text = park.description.orEmpty()
            if (!park.imageUrl.isNullOrBlank()) {
                Glide.with(this).load(park.imageUrl).into(detailImageView)
            }
            return
        }

        // 2) Otherwise treat it as a Campground using string extras (Option A)
        val name = intent.getStringExtra("name").orEmpty()
        val description = intent.getStringExtra("description").orEmpty()
        val imageUrl = intent.getStringExtra("imageUrl").orEmpty()

        detailTitleTextView.text = name
        detailDescriptionTextView.text = description

        if (imageUrl.isNotBlank()) {
            Glide.with(this).load(imageUrl).into(detailImageView)
        }
    }
}