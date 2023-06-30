package com.bayraktar.movieappcompose.data.repository

import com.bayraktar.movieappcompose.data.DataTransforObject.MovieDetailDTO
import com.bayraktar.movieappcompose.data.DataTransforObject.MoviesDTO
import com.bayraktar.movieappcompose.data.remote.ApiService
import com.bayraktar.movieappcompose.domain.repository.MovieRepository
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val api: ApiService
): MovieRepository {

    override suspend fun getMovies(search: String): MoviesDTO {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbID: String): MovieDetailDTO {
        return api.getMovieDetail(imdbID = imdbID)
    }
}