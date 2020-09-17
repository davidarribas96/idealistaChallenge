package com.idealista.android.challenge.detail.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity

data class AdDetail(
    val id: String,
    val price: Double,
    val comment: String,
    val thumbnail: String,
    val typology: Typology,
    val operation: Operation
)

fun AdDetailEntity.toDomain() =
    AdDetail(
        adid ?: "",
        price ?: 0.0,
        propertyComment ?: "",
        multimedia?.images?.get(0)?.url ?: "",
        Typology.from(extendedPropertyType ?: ""),
        Operation.from(operation ?: "")
        )
