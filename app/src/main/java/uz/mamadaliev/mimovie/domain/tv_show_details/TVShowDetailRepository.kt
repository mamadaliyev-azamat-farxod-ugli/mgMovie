package uz.mamadaliev.mimovie.domain.tv_show_details

import kotlinx.coroutines.flow.Flow
import uz.mamadaliev.mimovie.data.base.BaseNetworkResult
import uz.mamadaliev.mimovie.data.movie_detail.model.remote.response.Credits
import uz.mamadaliev.mimovie.data.movie_detail.model.remote.response.MovieTrailerRes
import uz.mamadaliev.mimovie.data.tv_show_details.models.TVShowDetails

interface TVShowDetailRepository {
    suspend fun getTVShowDetailById(id: Long): Flow<BaseNetworkResult<TVShowDetails>>

    suspend fun getTVTrailerListById(id: Long): Flow<BaseNetworkResult<MovieTrailerRes>>

    suspend fun getCredits(id: Long): Flow<BaseNetworkResult<Credits>>
}