package com.bayraktar.movieappcompose.data.remote

import com.bayraktar.movieappcompose.data.DataTransforObject.MovieDetailDTO
import com.bayraktar.movieappcompose.data.DataTransforObject.MoviesDTO
import com.bayraktar.movieappcompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    //https://www.omdbapi.com/?apikey=3cb5a5b&s=batman

    //no extension after base url, thats why we created empty GET
    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MoviesDTO

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbID: String,
        @Query("apikey") apiKey: String = API_KEY
    ): MovieDetailDTO
}