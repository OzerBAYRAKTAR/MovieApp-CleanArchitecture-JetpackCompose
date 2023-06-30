package com.bayraktar.movieappcompose.data.mapper

import com.bayraktar.movieappcompose.data.DataTransforObject.MovieDetailDTO
import com.bayraktar.movieappcompose.data.DataTransforObject.MoviesDTO
import com.bayraktar.movieappcompose.domain.model.Movie
import com.bayraktar.movieappcompose.domain.model.MovieDetail

//we used map because we wanted to get Search object which is inside the MoviesDTO.
//we converted response of search data to movie class which we created in domain
fun MoviesDTO.toMovieList(): List<Movie> {
    return Search.map { it -> Movie(it.Poster, it.Title, it.Year, it.imdbID) }
}


//we converted response model MovieDetailDTO to MovieDetail which we created in domain to use in presentation
fun MovieDetailDTO.toMovieDetail(): MovieDetail {
    return MovieDetail(
        Actors,
        Awards,
        Country,
        Director,
        Genre,
        Language,
        Poster,
        Rated,
        Released,
        Title,
        Type,
        Year,
        imdbRating
    )
}