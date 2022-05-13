package com.matheusmt.wikirick.data.client

import com.matheusmt.wikirick.data.URLs
import com.matheusmt.wikirick.data.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val DEFAULT_LIMIT = 1

interface RickAndMortyAPI {

    @GET(URLs.GET_CHARACTER_LIST)
    suspend fun getCharacter(
        @Query("page") page: Int = DEFAULT_LIMIT
    ): RickAndMortyResponse

    @GET(URLs.GET_CHARACTER_LIST)
    suspend fun getCharacterNextPage(
        @Query("page") page: Int = DEFAULT_LIMIT
    ): RickAndMortyResponse

}