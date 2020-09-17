package com.idealista.android.challenge.detail

import com.idealista.android.challenge.UnitTest
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.ImageEntity
import com.idealista.android.challenge.core.model.entity.MultimediasEntity
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.detail.data.DetailDataSource
import com.idealista.android.challenge.detail.data.DetailRepository
import com.idealista.android.challenge.detail.domain.toDomain
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import org.amshove.kluent.shouldEqual
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call
import retrofit2.Response

class DetailRepositoryTest : UnitTest() {

    private lateinit var repository: DetailRepository

    @Mock
    private lateinit var detailResponse: Response<AdDetailEntity>

    @Mock
    private lateinit var detailCall: Call<AdDetailEntity>

    @Mock
    private lateinit var detailDataSource: DetailDataSource

    @Test
    fun `verify get detail return success`() {
        val adDetailEntity = AdDetailEntity(
            "", 0.0, "", "", "", MultimediasEntity(
                mutableListOf(
                    ImageEntity(""), ImageEntity("")
                )
            )
        )
        given { detailResponse.body() }.willReturn(adDetailEntity)
        given { detailResponse.isSuccessful }.willReturn(true)
        given { detailCall.execute() }.willReturn(detailResponse)
        val either = Either.Right(adDetailEntity)
        given { detailDataSource.detail("") }.willReturn(either)

        repository = DetailRepository(detailDataSource)

        val getDetail = repository.detail("")
        getDetail shouldEqual Either.Right(adDetailEntity.toDomain())

        verify(detailDataSource).detail("")
    }
}