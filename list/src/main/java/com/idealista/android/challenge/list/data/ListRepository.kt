package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.AdEntity
import com.idealista.android.challenge.core.model.entity.ListEntity
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.domain.List
import com.idealista.android.challenge.list.domain.toDomain
import com.idealista.android.challenge.list.ui.AdModel

class ListRepository(private val dataSource: ListDataSource) {

    fun list(): Either<CommonError, List> = dataSource.list().map { it.toDomain() }

    fun update(ad: AdModel)= dataSource.update(ad).map { it.toDomain() }
}