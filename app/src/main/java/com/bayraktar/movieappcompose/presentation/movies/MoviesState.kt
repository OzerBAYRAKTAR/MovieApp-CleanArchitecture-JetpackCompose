package com.bayraktar.movieappcompose.presentation.movies

import com.bayraktar.movieappcompose.domain.model.Movie

//we check situation of screen
data class MoviesState (
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search: String = "Batman" // default search text
        )
