package com.matheusmt.wikirick.repository

import com.matheusmt.wikirick.data.model.CustomResponse
import com.matheusmt.wikirick.data.model.RickAndMortyResponse

interface RickAndMortyListService{
    suspend fun getListCharacter() : CustomResponse<RickAndMortyResponse>
    suspend fun getNextPage(url: String) : CustomResponse<RickAndMortyResponse>
}