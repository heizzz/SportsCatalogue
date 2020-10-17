package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.SportResponse
import com.example.core.domain.model.Sport
import com.example.core.domain.repository.ISportRepository
import com.example.core.utils.AppExecutors
import com.example.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {


    override fun getAllSport(): Flow<Resource<List<Sport>>> =
        object :  NetworkBoundResource<List<Sport>, List<SportResponse>>() {
            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllSport().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<SportResponse>>> =
                remoteDataSource.getAllSport()

            override suspend fun saveCallResult(data: List<SportResponse>) {
                val sportList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSport(sportList)
            }
        }.asFlow()

    override fun getFavoriteSport(): Flow<List<Sport>> {
        return localDataSource.getFavoriteSport().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteSport(sport: Sport, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(sport)
        appExecutors.diskIO().execute { localDataSource.setFavoriteSport(sportEntity, state) }
    }
}