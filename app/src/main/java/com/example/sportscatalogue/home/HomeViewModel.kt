package com.example.sportscatalogue.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.SportUseCase

class HomeViewModel(sportUseCase: SportUseCase) : ViewModel() {
    val sport = sportUseCase.getAllSport().asLiveData()
}