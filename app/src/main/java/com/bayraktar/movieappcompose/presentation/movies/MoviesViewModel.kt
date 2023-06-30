package com.bayraktar.movieappcompose.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bayraktar.movieappcompose.domain.use_case.get_movies.GetMoviesUseCase
import com.bayraktar.movieappcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val case: GetMoviesUseCase
) : ViewModel() {

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state: State<MoviesState>
        get() = _state

    //if there is already case.invoke function working on , we maybe want to cancel it to new one
    private var job : Job? = null

    //when viewmodel used in screen, init function will work and user will see batman (because we defined "batman" in search)
    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(search: String) {
        job?.cancel()

        job = case.invoke(search).onEach {movie ->
            when (movie) {
                is Resource.Success -> {
                    _state.value = MoviesState(movies = movie.data ?: emptyList())
                }
                is Resource.Loading -> {
                     _state.value = MoviesState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = MoviesState(error = movie.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope) // we use launchIn for to define which scope in we working for or we could use viewmodelScope.launch{}

    }
    //listen to events
    fun onEvent(event: MoviesEvent) {
        when (event) {
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
        }
    }
}