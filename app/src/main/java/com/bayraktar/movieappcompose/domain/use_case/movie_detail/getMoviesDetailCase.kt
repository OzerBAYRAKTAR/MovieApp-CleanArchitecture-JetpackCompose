package com.bayraktar.movieappcompose.domain.use_case.movie_detail

import com.bayraktar.movieappcompose.data.mapper.toMovieDetail
import com.bayraktar.movieappcompose.data.mapper.toMovieList
import com.bayraktar.movieappcompose.domain.model.Movie
import com.bayraktar.movieappcompose.domain.model.MovieDetail
import com.bayraktar.movieappcompose.domain.repository.MovieRepository
import com.bayraktar.movieappcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class getMoviesDetailCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(imdbID: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbID = imdbID)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        }
        catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}