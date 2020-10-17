package com.example.sportscatalogue.di

import com.example.core.domain.usecase.SportInteractor
import com.example.core.domain.usecase.SportUseCase
import com.example.sportscatalogue.detail.DetailSportViewModel
import com.example.sportscatalogue.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailSportViewModel(get()) }
}