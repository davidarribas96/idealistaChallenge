package com.idealista.android.challenge.detail.ui

import com.idealista.android.challenge.detail.domain.AdDetail

interface DetailView {
    fun render(ad: AdDetailModel)
}