package uz.mamadaliev.mimovie.domain.actors

import kotlinx.coroutines.flow.Flow
import uz.mamadaliev.mimovie.data.actors.model.remote.ActorsResponse
import uz.mamadaliev.mimovie.data.base.BaseNetworkResult
import javax.inject.Inject

class ActorsListUseCase @Inject constructor(private val actorsRepository: ActorsListRepository) {
    suspend fun getAllWeeklyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getAllWeeklyFamousPersons()
    }

    suspend fun getAllDailyFamousPersons(): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getAllDailyFamousPersons()
    }

    suspend fun getSearchedActors(
        query: String,
    ): Flow<BaseNetworkResult<ActorsResponse>> {
        return actorsRepository.getSearchedActors(query)
    }
}