package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.SportUseCase

class FavoriteViewModel(tourismUseCase: SportUseCase) : ViewModel() {
    val favoriteSport = tourismUseCase.getFavoriteSport().asLiveData()
}

