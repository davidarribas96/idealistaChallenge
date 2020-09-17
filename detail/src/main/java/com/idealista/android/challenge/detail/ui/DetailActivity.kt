package com.idealista.android.challenge.detail.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.detail.BuildConfig
import com.idealista.android.challenge.detail.DetailAssembler
import com.idealista.android.challenge.detail.R
import com.idealista.android.challenge.detail.databinding.ActivityDetailBinding
import com.idealista.android.challenge.detail.domain.AdDetail
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val url = intent.getStringExtra("URL")?.replace("https://run.mocky.io/v3/", "")?:""
        DetailAssembler.presenter = DetailPresenter(this)
        DetailAssembler.presenter.onDetailNeeded(url)
    }

    override fun render(ad: AdDetailModel) {

        if (ad.thumbnail.isNotEmpty()) Picasso.with(binding.ivAd.context).load(ad.thumbnail)
            .into(binding.ivAd)
        binding.tvTitle.text = ad.title
        binding.tvPrice.text = ad.price
        binding.tvComment.text = ad.comment
    }
}