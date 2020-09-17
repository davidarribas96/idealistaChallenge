package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.ListEntity
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.ListRepository
import com.idealista.android.challenge.list.ui.AdModel
import com.idealista.android.challenge.list.ui.toModel

fun list(repository: ListRepository): () -> Either<CommonError, List> = {
    repository.list()
}

fun update(repository: ListRepository, ad: AdModel): () -> Either<CommonError, List> = {
    repository.update(ad)
}