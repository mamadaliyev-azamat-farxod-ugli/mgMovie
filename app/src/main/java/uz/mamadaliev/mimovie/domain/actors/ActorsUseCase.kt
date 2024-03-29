package uz.mamadaliev.mimovie.domain.actors

import kotlinx.coroutines.flow.Flow
import uz.mamadaliev.mimovie.data.actors.model.local.ActorsResultDto
import uz.mamadaliev.mimovie.data.actors.model.remote.movie_credits.ActorCreditsInMovies
import uz.mamadaliev.mimovie.data.actors.model.remote.tv_credits.ActorCreditsInTVShows
import uz.mamadaliev.mimovie.data.base.BaseNetworkResult
import javax.inject.Inject

class ActorsUseCase @Inject constructor(private val actorsRepository: ActorsRepository) {
    suspend fun getPersonDetailById(id: Long): Flow<BaseNetworkResult<ActorsResultDto>> {
        return actorsRepository.getPersonDetailById(id)
    }

    suspend fun getMovieCreditsById(id: Long): Flow<BaseNetworkResult<ActorCreditsInMovies>> {
        return actorsRepository.getMovieCreditsById(id)
    }

    suspend fun getTVCreditsById(id: Long): Flow<BaseNetworkResult<ActorCreditsInTVShows>> {
        return actorsRepository.getTVCreditsById(id)
    }
}