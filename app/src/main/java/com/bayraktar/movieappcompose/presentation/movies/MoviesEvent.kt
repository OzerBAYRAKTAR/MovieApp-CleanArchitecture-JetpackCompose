package com.bayraktar.movieappcompose.presentation.movies

sealed class MoviesEvent {
    //kullanıcının etkileşime geçeceği kısımlar için
    data class Search(val searchString: String): MoviesEvent()
}