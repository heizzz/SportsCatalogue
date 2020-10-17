package com.example.favorite

import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}