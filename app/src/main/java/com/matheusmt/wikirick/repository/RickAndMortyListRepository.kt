package com.matheusmt.wikirick.repository

import com.matheusmt.wikirick.data.client.RickAndMortyAPI
import com.matheusmt.wikirick.data.model.CustomResponse
import com.matheusmt.wikirick.data.model.RickAndMortyResponse

class RickAndMortyListRepository(private val api: RickAndMortyAPI) : RickAndMortyListService {

    override suspend fun getListCharacter(): CustomResponse<RickAndMortyResponse> {
        return try {
            val result = api.getCharacter()
            CustomResponse.Success(result)
        } catch (e: Exception) {
            CustomResponse.Error(e)
        }
    }

    override suspend fun getNextPage(url: String): CustomResponse<RickAndMortyResponse> {
        return try {
            val result = api.getCharacterNextPage(url.toInt())
            CustomResponse.Success(result)
        } catch (e: Exception) {
            CustomResponse.Error(e)
        }
    }
}