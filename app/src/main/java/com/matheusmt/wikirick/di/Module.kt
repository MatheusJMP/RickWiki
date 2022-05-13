package com.matheusmt.wikirick.di

import com.matheusmt.wikirick.data.client.RickAndMortyAPI
import com.matheusmt.wikirick.data.client.RetrofitClient
import com.matheusmt.wikirick.BuildConfig
import com.matheusmt.wikirick.repository.RickAndMortyListRepository
import com.matheusmt.wikirick.repository.RickAndMortyListService
import com.matheusmt.wikirick.viewmodel.RickAndMortyListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single {
        RetrofitClient().createWebService<RickAndMortyAPI>(
            okHttpClient = RetrofitClient().createHttpClient(),
            baseUrl = BuildConfig.BASE_RICKANDMORTY_URL
        )
    }

    factory<RickAndMortyListService> { RickAndMortyListRepository(api = get()) }
    viewModel { RickAndMortyListViewModel(repository = get()) }
}