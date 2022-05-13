package com.matheusmt.wikirick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheusmt.wikirick.viewmodel.RickAndMortyListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: RickAndMortyListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getList()
        viewModel.getNextPage()

    }
}