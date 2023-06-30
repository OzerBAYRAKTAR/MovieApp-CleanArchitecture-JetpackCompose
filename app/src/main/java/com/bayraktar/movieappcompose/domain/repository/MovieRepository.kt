package com.bayraktar.movieappcompose.domain.repository

import com.bayraktar.movieappcompose.data.DataTransforObject.MovieDetailDTO
import com.bayraktar.movieappcompose.data.DataTransforObject.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDTO
    suspend fun getMovieDetail(imdbID: String): MovieDetailDTO
}