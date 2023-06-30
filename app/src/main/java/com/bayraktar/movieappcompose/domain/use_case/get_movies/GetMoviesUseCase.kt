package com.bayraktar.movieappcompose.domain.use_case.get_movies

import com.bayraktar.movieappcompose.data.mapper.toMovieList
import com.bayraktar.movieappcompose.domain.model.Movie
import com.bayraktar.movieappcompose.domain.repository.MovieRepository
import com.bayraktar.movieappcompose.util.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search = search)
            if (movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            }else{
                emit(Resource.Error(message = "No movie found"))
            }
        } catch (e: IOError) {
            emit(Resource.Error("No internet connection"))
        }
        catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }
}