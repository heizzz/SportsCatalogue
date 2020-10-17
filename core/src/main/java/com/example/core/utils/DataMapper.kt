package com.example.core.utils

import com.example.core.data.source.local.entity.SportEntity
import com.example.core.data.source.remote.response.SportResponse
import com.example.core.domain.model.Sport

object DataMapper {
    fun mapResponsesToEntities(input: List<SportResponse>): List<SportEntity> {
        val sportList = ArrayList<SportEntity>()
        input.map {
            val sport = SportEntity(
                sportId = it.id,
                description = it.description,
                name = it.name,
                thumb = it.thumb,
                thumbGreen = it.thumbGreen,
                format = it.format,
                isFavorite = false
            )
            sportList.add(sport)
        }
        return sportList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> =
        input.map {
            Sport(
                sportId = it.sportId,
                description = it.description,
                name = it.name,
                thumb = it.thumb,
                thumbGreen = it.thumbGreen,
                format = it.format,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Sport) = SportEntity(
        sportId = input.sportId,
        description = input.description,
        name = input.name,
        thumb = input.thumb,
        format = input.format,
        thumbGreen = input.thumbGreen,
        isFavorite = input.isFavorite
    )

}