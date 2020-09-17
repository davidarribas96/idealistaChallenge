package com.idealista.android.challenge.detail.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.detail.data.DetailRepository

fun detail(repository: DetailRepository, url: String): () -> Either<CommonError, AdDetail> = {
    repository.detail(url)
}