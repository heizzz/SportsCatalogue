package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllSport(): Flow<Resource<List<Sport>>>
    fun getFavoriteSport(): Flow<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}