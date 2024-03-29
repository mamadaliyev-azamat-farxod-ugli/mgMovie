package uz.mamadaliev.mimovie.data.tv_shows

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import uz.mamadaliev.mimovie.data.base.BaseNetworkResult
import uz.mamadaliev.mimovie.data.tv_shows.models.TVShowsResponse
import uz.mamadaliev.mimovie.data.tv_shows.models.TVShowsResult
import uz.mamadaliev.mimovie.domain.tv_shows.TVShowsRepository
import javax.inject.Inject

class TVShowsRepositoryImpl @Inject constructor(private val service: TVShowsService) :
    TVShowsRepository {
    override suspend fun getAllTopRatedTVShows(query: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllTopRatedTVShows()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(
                    BaseNetworkResult.Success(
                        response.body() ?: TVShowsResponse(
                            0,
                            listOf(
                                TVShowsResult(
                                    "", "",
                                    listOf(0, 1), 0, "",
                                    listOf("US"), "", "", "", 0.1, "", 0.1, 0
                                )
                            ), 0, 0
                        )
                    )
                )
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getPopularTVShows(@Query(value = "api_key") closeReason: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAllPopularTVShows()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(
                    BaseNetworkResult.Success(
                        response.body() ?: TVShowsResponse(
                            0,
                            listOf(
                                TVShowsResult(
                                    "", "",
                                    listOf(0, 1), 0, "",
                                    listOf("US"), "", "", "", 0.1, "", 0.1, 0
                                )
                            ), 0, 0
                        )
                    )
                )
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getOnTheAirTVShows(@Query(value = "api_key") closeReason: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getOnTheAirTVShows()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(
                    BaseNetworkResult.Success(
                        response.body() ?: TVShowsResponse(
                            0,
                            listOf(
                                TVShowsResult(
                                    "", "",
                                    listOf(0, 1), 0, "",
                                    listOf("US"), "", "", "", 0.1, "", 0.1, 0
                                )
                            ), 0, 0
                        )
                    )
                )
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getAiringTodayTVShows(@Query(value = "api_key") closeReason: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getAiringTodayTVShows()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(
                    BaseNetworkResult.Success(
                        response.body() ?: TVShowsResponse(
                            0,
                            listOf(
                                TVShowsResult(
                                    "", "",
                                    listOf(0, 1), 0, "",
                                    listOf("US"), "", "", "", 0.1, "", 0.1, 0
                                )
                            ), 0, 0
                        )
                    )
                )
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }

    override suspend fun getSearchedTVShows(query: String): Flow<BaseNetworkResult<TVShowsResponse>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = service.getSearchedTVShows(query = query)
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }
}