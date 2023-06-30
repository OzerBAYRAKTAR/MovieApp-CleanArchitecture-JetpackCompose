package com.bayraktar.movieappcompose.data.DataTransforObject

import com.bayraktar.movieappcompose.domain.model.Movie

data class MoviesDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

