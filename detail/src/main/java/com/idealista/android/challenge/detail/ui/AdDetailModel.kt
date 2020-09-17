package com.idealista.android.challenge.detail.ui

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.R
import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.string
import com.idealista.android.challenge.detail.domain.AdDetail

data class AdDetailModel(
    val id: String,
    val price: String,
    val comment: String,
    val thumbnail: String,
    val title: String
)

fun AdDetail.toModel() =
    AdDetailModel(id, formatPrice(price), comment, thumbnail, formatTitle(typology, operation))

private fun formatPrice(price: Double) = "$price €"
private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string(),
        operation.string().toLowerCase()
    )
