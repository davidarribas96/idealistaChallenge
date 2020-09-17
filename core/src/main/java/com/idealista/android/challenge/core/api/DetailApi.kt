package com.idealista.android.challenge.core.api

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.ListEntity
import com.idealista.android.challenge.core.api.retrofit.run
import com.idealista.android.challenge.core.api.retrofit.toDomain
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.wrench.type.Either

class DetailApi(private val client: ApiClient) {

    fun detail(url:String): Either<CommonError, AdDetailEntity> = with (client) {
        apiService.detail(url).run().toDomain()
    }
}